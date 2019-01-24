package com.example.datastruct.rpc.consumer;

import com.example.datastruct.rpc.provider.Caculate;
import com.example.datastruct.rpc.request.CaculateRpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CaculateRemoteImpl implements Caculate {

    final static int PORT = 8030;

    public int add(int a, int b) {
        List<String> addressList = findAddress("Cacualte.add");

        String address = chooseAddress(addressList);

        try {
            Socket socket = new Socket(address, PORT);

            CaculateRpcRequest request = generateRequest(a, b);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(request);

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object response = objectInputStream.readObject();

            if (response instanceof Integer) {
                return (Integer) response;
            } else {
                throw new InternalError();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }


    private CaculateRpcRequest generateRequest(int a, int b) {
        CaculateRpcRequest caculateRpcRequest = new CaculateRpcRequest();
        caculateRpcRequest.setA(a);
        caculateRpcRequest.setB(b);
        caculateRpcRequest.setMethod("add");
        return caculateRpcRequest;
    }

    private List<String> findAddress(String name) {
        List<String> list = new ArrayList<>();
        list.add("127.0.0.1");
        return list;
    }

    private String chooseAddress(List<String> list) {
        if (null == list || list.size() == 0) {
            throw new IllegalArgumentException();
        }

        return list.get(0);
    }
}
