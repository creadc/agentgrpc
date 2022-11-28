// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: project.proto

package com.example.agentgrpc.protocol.project;

public interface NodeStateResOrBuilder extends
    // @@protoc_insertion_point(interface_extends:agent.NodeStateRes)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *执行状态，0成功-1失败-2执行中
   * </pre>
   *
   * <code>int32 code = 1;</code>
   * @return The code.
   */
  int getCode();

  /**
   * <pre>
   *是否在线 0在线-1不在线-2(可以增加)宕机
   * </pre>
   *
   * <code>int32 is_up = 2;</code>
   * @return The isUp.
   */
  int getIsUp();

  /**
   * <pre>
   *其他属性，如jar_time
   * </pre>
   *
   * <code>map&lt;string, string&gt; attrs = 3;</code>
   */
  int getAttrsCount();
  /**
   * <pre>
   *其他属性，如jar_time
   * </pre>
   *
   * <code>map&lt;string, string&gt; attrs = 3;</code>
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
   *其他属性，如jar_time
   * </pre>
   *
   * <code>map&lt;string, string&gt; attrs = 3;</code>
   */
  java.util.Map<java.lang.String, java.lang.String>
  getAttrsMap();
  /**
   * <pre>
   *其他属性，如jar_time
   * </pre>
   *
   * <code>map&lt;string, string&gt; attrs = 3;</code>
   */

  java.lang.String getAttrsOrDefault(
      java.lang.String key,
      java.lang.String defaultValue);
  /**
   * <pre>
   *其他属性，如jar_time
   * </pre>
   *
   * <code>map&lt;string, string&gt; attrs = 3;</code>
   */

  java.lang.String getAttrsOrThrow(
      java.lang.String key);
}