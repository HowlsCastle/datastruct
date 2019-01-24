package com.example.datastruct.rpc.consumer;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsumerService {

    public static void main(String[] args) {
        CaculateRemoteImpl caculateRemote = new CaculateRemoteImpl();
        caculateRemote.add(1,2);
    }
}
