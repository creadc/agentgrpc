// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: stress.proto

package com.example.agentgrpc.protocol.stress;

public interface JsonResultResOrBuilder extends
    // @@protoc_insertion_point(interface_extends:agent.JsonResultRes)
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
   *详细信息
   * </pre>
   *
   * <code>string message = 2;</code>
   * @return The message.
   */
  java.lang.String getMessage();
  /**
   * <pre>
   *详细信息
   * </pre>
   *
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>string file_name = 3;</code>
   * @return The fileName.
   */
  java.lang.String getFileName();
  /**
   * <code>string file_name = 3;</code>
   * @return The bytes for fileName.
   */
  com.google.protobuf.ByteString
      getFileNameBytes();

  /**
   * <code>string chunk = 4;</code>
   * @return The chunk.
   */
  java.lang.String getChunk();
  /**
   * <code>string chunk = 4;</code>
   * @return The bytes for chunk.
   */
  com.google.protobuf.ByteString
      getChunkBytes();
}
