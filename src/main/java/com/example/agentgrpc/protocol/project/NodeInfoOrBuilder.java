// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: project.proto

package com.example.agentgrpc.protocol.project;

public interface NodeInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:agent.NodeInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *proj ip
   * </pre>
   *
   * <code>string ip = 1;</code>
   * @return The ip.
   */
  java.lang.String getIp();
  /**
   * <pre>
   *proj ip
   * </pre>
   *
   * <code>string ip = 1;</code>
   * @return The bytes for ip.
   */
  com.google.protobuf.ByteString
      getIpBytes();

  /**
   * <pre>
   *proj port
   * </pre>
   *
   * <code>string port = 2;</code>
   * @return The port.
   */
  java.lang.String getPort();
  /**
   * <pre>
   *proj port
   * </pre>
   *
   * <code>string port = 2;</code>
   * @return The bytes for port.
   */
  com.google.protobuf.ByteString
      getPortBytes();

  /**
   * <code>string webapps = 3;</code>
   * @return The webapps.
   */
  java.lang.String getWebapps();
  /**
   * <code>string webapps = 3;</code>
   * @return The bytes for webapps.
   */
  com.google.protobuf.ByteString
      getWebappsBytes();

  /**
   * <code>string servlet = 4;</code>
   * @return The servlet.
   */
  java.lang.String getServlet();
  /**
   * <code>string servlet = 4;</code>
   * @return The bytes for servlet.
   */
  com.google.protobuf.ByteString
      getServletBytes();

  /**
   * <pre>
   *proj lib目录
   * </pre>
   *
   * <code>string lib_path = 5;</code>
   * @return The libPath.
   */
  java.lang.String getLibPath();
  /**
   * <pre>
   *proj lib目录
   * </pre>
   *
   * <code>string lib_path = 5;</code>
   * @return The bytes for libPath.
   */
  com.google.protobuf.ByteString
      getLibPathBytes();

  /**
   * <pre>
   *tomcat bin 目录
   * </pre>
   *
   * <code>string bin_path = 6;</code>
   * @return The binPath.
   */
  java.lang.String getBinPath();
  /**
   * <pre>
   *tomcat bin 目录
   * </pre>
   *
   * <code>string bin_path = 6;</code>
   * @return The bytes for binPath.
   */
  com.google.protobuf.ByteString
      getBinPathBytes();

  /**
   * <pre>
   *工程类型 1.tomcat 2.tongweb 3.bes 4.apusic 5.tas 6.infors 7.docker
   * </pre>
   *
   * <code>int32 proj_type = 7;</code>
   * @return The projType.
   */
  int getProjType();

  /**
   * <pre>
   *其他属性，用于适配国产化
   * </pre>
   *
   * <code>map&lt;string, string&gt; attrs = 8;</code>
   */
  int getAttrsCount();
  /**
   * <pre>
   *其他属性，用于适配国产化
   * </pre>
   *
   * <code>map&lt;string, string&gt; attrs = 8;</code>
   */
  boolean containsAttrs(
      java.lang.String key);
  /**
   * Use {@link #getAttrsMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, java.lang.String>
  getAttrs();
  /**
   * <pre>
   *其他属性，用于适配国产化
   * </pre>
   *
   * <code>map&lt;string, string&gt; attrs = 8;</code>
   */
  java.util.Map<java.lang.String, java.lang.String>
  getAttrsMap();
  /**
   * <pre>
   *其他属性，用于适配国产化
   * </pre>
   *
   * <code>map&lt;string, string&gt; attrs = 8;</code>
   */

  java.lang.String getAttrsOrDefault(
      java.lang.String key,
      java.lang.String defaultValue);
  /**
   * <pre>
   *其他属性，用于适配国产化
   * </pre>
   *
   * <code>map&lt;string, string&gt; attrs = 8;</code>
   */

  java.lang.String getAttrsOrThrow(
      java.lang.String key);
}
