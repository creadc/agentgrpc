// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: debug.proto

package com.example.agentgrpc.protocol.debug;

public final class DebugOuterClass {
  private DebugOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_agent_ContextReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_agent_ContextReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_agent_ContextRes_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_agent_ContextRes_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_agent_TestReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_agent_TestReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_agent_TestRes_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_agent_TestRes_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013debug.proto\022\005agent\"\031\n\nContextReq\022\013\n\003re" +
      "q\030\001 \001(\t\"\031\n\nContextRes\022\013\n\003res\030\001 \001(\t\"\026\n\007Te" +
      "stReq\022\013\n\003req\030\001 \001(\t\"\026\n\007TestRes\022\013\n\003res\030\001 \001" +
      "(\t2n\n\005Debug\022;\n\021GetServletContext\022\021.agent" +
      ".ContextReq\032\021.agent.ContextRes\"\000\022(\n\004Test" +
      "\022\016.agent.TestReq\032\016.agent.TestRes\"\000B;\n$co" +
      "m.example.agentgrpc.protocol.debugP\001Z\021pr" +
      "otocol/v1/agentb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_agent_ContextReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_agent_ContextReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_agent_ContextReq_descriptor,
        new java.lang.String[] { "Req", });
    internal_static_agent_ContextRes_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_agent_ContextRes_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_agent_ContextRes_descriptor,
        new java.lang.String[] { "Res", });
    internal_static_agent_TestReq_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_agent_TestReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_agent_TestReq_descriptor,
        new java.lang.String[] { "Req", });
    internal_static_agent_TestRes_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_agent_TestRes_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_agent_TestRes_descriptor,
        new java.lang.String[] { "Res", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
