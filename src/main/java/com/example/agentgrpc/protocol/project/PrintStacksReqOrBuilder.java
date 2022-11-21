// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: project.proto

package com.example.agentgrpc.protocol.project;

public interface PrintStacksReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:agent.PrintStacksReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *任务队列id
   * </pre>
   *
   * <code>string exec_id = 1;</code>
   * @return The execId.
   */
  java.lang.String getExecId();
  /**
   * <pre>
   *任务队列id
   * </pre>
   *
   * <code>string exec_id = 1;</code>
   * @return The bytes for execId.
   */
  com.google.protobuf.ByteString
      getExecIdBytes();

  /**
   * <pre>
   *当前任务在任务队列中的索引
   * </pre>
   *
   * <code>int32 index = 2;</code>
   * @return The index.
   */
  int getIndex();

  /**
   * <code>.agent.NodeInfo node = 3;</code>
   * @return Whether the node field is set.
   */
  boolean hasNode();
  /**
   * <code>.agent.NodeInfo node = 3;</code>
   * @return The node.
   */
  com.example.agentgrpc.protocol.project.NodeInfo getNode();
  /**
   * <code>.agent.NodeInfo node = 3;</code>
   */
  com.example.agentgrpc.protocol.project.NodeInfoOrBuilder getNodeOrBuilder();

  /**
   * <pre>
   *打堆栈间隔
   * </pre>
   *
   * <code>int32 interval = 4;</code>
   * @return The interval.
   */
  int getInterval();
}
