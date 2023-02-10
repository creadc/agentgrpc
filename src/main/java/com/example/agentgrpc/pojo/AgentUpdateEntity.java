package com.example.agentgrpc.pojo;

public class AgentUpdateEntity {
    private int code;
    private String message;
    private String execid;
    private int index;
    private int pid; //agent的pid
    private String oldJarName;
    private String newJarName;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExecid() {
        return execid;
    }

    public void setExecid(String execid) {
        this.execid = execid;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getOldJarName() {
        return oldJarName;
    }

    public void setOldJarName(String oldJarName) {
        this.oldJarName = oldJarName;
    }

    public String getNewJarName() {
        return newJarName;
    }

    public void setNewJarName(String newJarName) {
        this.newJarName = newJarName;
    }
}
