package com.example.datastruct.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class KillProcess {

    /**
     * pid =  [1, 3, 10, 5]
     * ppid = [3, 0, 5, 3]
     * @param pid
     * @param ppid
     * @param kill
     * @return
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> processTree = new HashMap<>();

        for(int i=0;i<ppid.size();i++) {
            if (!processTree.containsKey(ppid.get(i))) {
                processTree.put(ppid.get(i), new ArrayList<>());
            }
            processTree.get(ppid.get(i)).add(pid.get(i));
        }

        List<Integer> ret = new ArrayList<>();
        ret.add(kill);
        List<Integer> killer = processTree.get(kill);
        System.out.println(killer);
        if (Objects.isNull(killer)) return ret;
        ret.addAll(killer);
        for(Integer k : killer) {
            if (Objects.nonNull(processTree.get(k))) {
                ret.addAll(processTree.get(k));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        List<Integer> pid = new ArrayList<>(Arrays.asList(1, 3, 10, 5, 13, 14, 15));
        List<Integer> ppid = new ArrayList<>(Arrays.asList(3,0,5,3, 5, 13, 13));

        KillProcess killProcess = new KillProcess();
        List<Integer> ret = killProcess.killProcess(pid, ppid, 5);
        for(Integer r: ret) {
            System.out.println(r);
        }

    }
}
