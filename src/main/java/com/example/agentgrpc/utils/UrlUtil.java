package com.example.agentgrpc.utils;

import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;

public class UrlUtil {
    public static String join(@Nullable String url, String... fragment) {
        StringBuilder sb = new StringBuilder(StringUtils.defaultIfBlank(url, "/").trim());

        for (String arg : fragment) {
            //去除尾部[/]
            char node = sb.charAt(sb.length() - 1);
            if (node == '/') {
                sb.deleteCharAt(sb.length() - 1);
            }
            if (StringUtils.isBlank(arg)) {
                continue;
            }
            arg = arg.trim();
            if (arg.charAt(0) != '/') {
                sb.append("/");
            }
            sb.append(arg);
        }
        return sb.toString();
    }
}
