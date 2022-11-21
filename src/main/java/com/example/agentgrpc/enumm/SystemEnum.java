package com.example.agentgrpc.enumm;

public enum SystemEnum {
    WINDOWS("Windows","\\","cmd","/c","gbk"),
    LINUX("Linux","/","/bin/sh","-c","utf-8");


    private final String systemType;
    private final String separator;
    private final String command1;
    private final String command2;
    private final String encoding;

    SystemEnum(String systemType, String separator, String command1, String command2, String encoding) {
        this.systemType = systemType;
        this.separator = separator;
        this.command1 = command1;
        this.command2 = command2;
        this.encoding = encoding;
    }

    public String getSystemType() {
        return systemType;
    }

    public String getSeparator() {
        return separator;
    }

    public String getCommand1() {
        return command1;
    }

    public String getCommand2() {
        return command2;
    }

    public String getEncoding() {
        return encoding;
    }

    public static String[] getTypeAndSeparator(){
        String os = System.getProperty("os.name");
        String[] s = new String[2];
        //linux
        if(os.equals("Linux")){
            s[0] = LINUX.systemType;
            s[1] = LINUX.separator;
            return s;
        }
        //windows
        else if (os.split(" ")[0].equals("Windows")){
            s[0] = WINDOWS.systemType;
            s[1] = WINDOWS.separator;
            return s;
        }
        else
            return null;
    };
}
