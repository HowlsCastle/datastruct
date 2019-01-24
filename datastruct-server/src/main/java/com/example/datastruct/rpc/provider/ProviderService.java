package com.example.datastruct.rpc.provider;

import com.example.datastruct.rpc.request.CaculateRpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ProviderService {
    Caculate caculate = new CaculateImpl();

    public static void main(String[] args) {

    }

    private void run() throws IOException {
        int port = 8030;

        ServerSocket listener = new ServerSocket(port);

        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                    Object object = objectInputStream.readObject();

                    int result = 0;
                    if (object instanceof CaculateRpcRequest) {
                        CaculateRpcRequest calculateRpcRequest = (CaculateRpcRequest) object;
                        if ("add".equals(calculateRpcRequest.getMethod())) {
                            result = caculate.add(calculateRpcRequest.getA(), calculateRpcRequest.getB());
                        } else {
                            throw new UnsupportedOperationException();
                        }

                        // 返回结果
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        objectOutputStream.writeObject(new Integer(result));
                    }
                } catch (Exception e) {

                }finally {
                    socket.close();
                }
            }
        } catch (Exception e) {

        } finally {
            listener.close();
        }
    }
}
