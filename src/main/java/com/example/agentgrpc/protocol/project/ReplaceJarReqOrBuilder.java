// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: project.proto

package com.example.agentgrpc.protocol.project;

public interface ReplaceJarReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:agent.ReplaceJarReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string exec_id = 1;</code>
   * @return The execId.
   */
  java.lang.String getExecId();
  /**
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
   *下载路径
   * </pre>
   *
   * <code>string download_url = 4;</code>
   * @return The downloadUrl.
   */
  java.lang.String getDownloadUrl();
  /**
   * <pre>
   *下载路径
   * </pre>
   *
   * <code>string download_url = 4;</code>
   * @return The bytes for downloadUrl.
   */
  com.google.protobuf.ByteString
      getDownloadUrlBytes();

  /**
   * <pre>
   *文件列表
   * </pre>
   *
   * <code>repeated string file_list = 5;</code>
   * @return A list containing the fileList.
   */
  java.util.List<java.lang.String>
      getFileListList();
  /**
   * <pre>
   *文件列表
   * </pre>
   *
   * <code>repeated string file_list = 5;</code>
   * @return The count of fileList.
   */
  int getFileListCount();
  /**
   * <pre>
   *文件列表
   * </pre>
   *
   * <code>repeated string file_list = 5;</code>
   * @param index The index of the element to return.
   * @return The fileList at the given index.
   */
  java.lang.String getFileList(int index);
  /**
   * <pre>
   *文件列表
   * </pre>
   *
   * <code>repeated string file_list = 5;</code>
   * @param index The index of the value to return.
   * @return The bytes of the fileList at the given index.
   */
  com.google.protobuf.ByteString
      getFileListBytes(int index);
}
