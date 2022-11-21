// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Collector.proto

package com.example.agentgrpc.protocol.collector;

/**
 * Protobuf type {@code platform.AgentStatusReq}
 */
public final class AgentStatusReq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:platform.AgentStatusReq)
    AgentStatusReqOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AgentStatusReq.newBuilder() to construct.
  private AgentStatusReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AgentStatusReq() {
    agentId_ = "";
    status_ = "";
    execList_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new AgentStatusReq();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AgentStatusReq(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            agentId_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            status_ = s;
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              execList_ = new java.util.ArrayList<com.example.agentgrpc.protocol.collector.TaskList>();
              mutable_bitField0_ |= 0x00000001;
            }
            execList_.add(
                input.readMessage(com.example.agentgrpc.protocol.collector.TaskList.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        execList_ = java.util.Collections.unmodifiableList(execList_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.agentgrpc.protocol.collector.CollectorOuterClass.internal_static_platform_AgentStatusReq_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.agentgrpc.protocol.collector.CollectorOuterClass.internal_static_platform_AgentStatusReq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.agentgrpc.protocol.collector.AgentStatusReq.class, com.example.agentgrpc.protocol.collector.AgentStatusReq.Builder.class);
  }

  public static final int AGENT_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object agentId_;
  /**
   * <pre>
   *暂定，id/name/ip等
   * </pre>
   *
   * <code>string agent_Id = 1;</code>
   * @return The agentId.
   */
  @java.lang.Override
  public java.lang.String getAgentId() {
    java.lang.Object ref = agentId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      agentId_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *暂定，id/name/ip等
   * </pre>
   *
   * <code>string agent_Id = 1;</code>
   * @return The bytes for agentId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getAgentIdBytes() {
    java.lang.Object ref = agentId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      agentId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int STATUS_FIELD_NUMBER = 2;
  private volatile java.lang.Object status_;
  /**
   * <pre>
   *状态，空闲/正在执行任务
   * </pre>
   *
   * <code>string status = 2;</code>
   * @return The status.
   */
  @java.lang.Override
  public java.lang.String getStatus() {
    java.lang.Object ref = status_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      status_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *状态，空闲/正在执行任务
   * </pre>
   *
   * <code>string status = 2;</code>
   * @return The bytes for status.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getStatusBytes() {
    java.lang.Object ref = status_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      status_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int EXEC_LIST_FIELD_NUMBER = 3;
  private java.util.List<com.example.agentgrpc.protocol.collector.TaskList> execList_;
  /**
   * <pre>
   *正在执行的任务列表
   * </pre>
   *
   * <code>repeated .platform.TaskList exec_list = 3;</code>
   */
  @java.lang.Override
  public java.util.List<com.example.agentgrpc.protocol.collector.TaskList> getExecListList() {
    return execList_;
  }
  /**
   * <pre>
   *正在执行的任务列表
   * </pre>
   *
   * <code>repeated .platform.TaskList exec_list = 3;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.example.agentgrpc.protocol.collector.TaskListOrBuilder> 
      getExecListOrBuilderList() {
    return execList_;
  }
  /**
   * <pre>
   *正在执行的任务列表
   * </pre>
   *
   * <code>repeated .platform.TaskList exec_list = 3;</code>
   */
  @java.lang.Override
  public int getExecListCount() {
    return execList_.size();
  }
  /**
   * <pre>
   *正在执行的任务列表
   * </pre>
   *
   * <code>repeated .platform.TaskList exec_list = 3;</code>
   */
  @java.lang.Override
  public com.example.agentgrpc.protocol.collector.TaskList getExecList(int index) {
    return execList_.get(index);
  }
  /**
   * <pre>
   *正在执行的任务列表
   * </pre>
   *
   * <code>repeated .platform.TaskList exec_list = 3;</code>
   */
  @java.lang.Override
  public com.example.agentgrpc.protocol.collector.TaskListOrBuilder getExecListOrBuilder(
      int index) {
    return execList_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(agentId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, agentId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(status_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, status_);
    }
    for (int i = 0; i < execList_.size(); i++) {
      output.writeMessage(3, execList_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(agentId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, agentId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(status_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, status_);
    }
    for (int i = 0; i < execList_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, execList_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.example.agentgrpc.protocol.collector.AgentStatusReq)) {
      return super.equals(obj);
    }
    com.example.agentgrpc.protocol.collector.AgentStatusReq other = (com.example.agentgrpc.protocol.collector.AgentStatusReq) obj;

    if (!getAgentId()
        .equals(other.getAgentId())) return false;
    if (!getStatus()
        .equals(other.getStatus())) return false;
    if (!getExecListList()
        .equals(other.getExecListList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + AGENT_ID_FIELD_NUMBER;
    hash = (53 * hash) + getAgentId().hashCode();
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + getStatus().hashCode();
    if (getExecListCount() > 0) {
      hash = (37 * hash) + EXEC_LIST_FIELD_NUMBER;
      hash = (53 * hash) + getExecListList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.agentgrpc.protocol.collector.AgentStatusReq parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.agentgrpc.protocol.collector.AgentStatusReq parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.agentgrpc.protocol.collector.AgentStatusReq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.agentgrpc.protocol.collector.AgentStatusReq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.agentgrpc.protocol.collector.AgentStatusReq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.agentgrpc.protocol.collector.AgentStatusReq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.agentgrpc.protocol.collector.AgentStatusReq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.agentgrpc.protocol.collector.AgentStatusReq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.agentgrpc.protocol.collector.AgentStatusReq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.agentgrpc.protocol.collector.AgentStatusReq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.agentgrpc.protocol.collector.AgentStatusReq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.agentgrpc.protocol.collector.AgentStatusReq parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.example.agentgrpc.protocol.collector.AgentStatusReq prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code platform.AgentStatusReq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:platform.AgentStatusReq)
      com.example.agentgrpc.protocol.collector.AgentStatusReqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.agentgrpc.protocol.collector.CollectorOuterClass.internal_static_platform_AgentStatusReq_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.agentgrpc.protocol.collector.CollectorOuterClass.internal_static_platform_AgentStatusReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.agentgrpc.protocol.collector.AgentStatusReq.class, com.example.agentgrpc.protocol.collector.AgentStatusReq.Builder.class);
    }

    // Construct using com.example.agentgrpc.protocol.collector.AgentStatusReq.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getExecListFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      agentId_ = "";

      status_ = "";

      if (execListBuilder_ == null) {
        execList_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        execListBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.agentgrpc.protocol.collector.CollectorOuterClass.internal_static_platform_AgentStatusReq_descriptor;
    }

    @java.lang.Override
    public com.example.agentgrpc.protocol.collector.AgentStatusReq getDefaultInstanceForType() {
      return com.example.agentgrpc.protocol.collector.AgentStatusReq.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.agentgrpc.protocol.collector.AgentStatusReq build() {
      com.example.agentgrpc.protocol.collector.AgentStatusReq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.agentgrpc.protocol.collector.AgentStatusReq buildPartial() {
      com.example.agentgrpc.protocol.collector.AgentStatusReq result = new com.example.agentgrpc.protocol.collector.AgentStatusReq(this);
      int from_bitField0_ = bitField0_;
      result.agentId_ = agentId_;
      result.status_ = status_;
      if (execListBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          execList_ = java.util.Collections.unmodifiableList(execList_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.execList_ = execList_;
      } else {
        result.execList_ = execListBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.agentgrpc.protocol.collector.AgentStatusReq) {
        return mergeFrom((com.example.agentgrpc.protocol.collector.AgentStatusReq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.agentgrpc.protocol.collector.AgentStatusReq other) {
      if (other == com.example.agentgrpc.protocol.collector.AgentStatusReq.getDefaultInstance()) return this;
      if (!other.getAgentId().isEmpty()) {
        agentId_ = other.agentId_;
        onChanged();
      }
      if (!other.getStatus().isEmpty()) {
        status_ = other.status_;
        onChanged();
      }
      if (execListBuilder_ == null) {
        if (!other.execList_.isEmpty()) {
          if (execList_.isEmpty()) {
            execList_ = other.execList_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureExecListIsMutable();
            execList_.addAll(other.execList_);
          }
          onChanged();
        }
      } else {
        if (!other.execList_.isEmpty()) {
          if (execListBuilder_.isEmpty()) {
            execListBuilder_.dispose();
            execListBuilder_ = null;
            execList_ = other.execList_;
            bitField0_ = (bitField0_ & ~0x00000001);
            execListBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getExecListFieldBuilder() : null;
          } else {
            execListBuilder_.addAllMessages(other.execList_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.example.agentgrpc.protocol.collector.AgentStatusReq parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.example.agentgrpc.protocol.collector.AgentStatusReq) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object agentId_ = "";
    /**
     * <pre>
     *暂定，id/name/ip等
     * </pre>
     *
     * <code>string agent_Id = 1;</code>
     * @return The agentId.
     */
    public java.lang.String getAgentId() {
      java.lang.Object ref = agentId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        agentId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *暂定，id/name/ip等
     * </pre>
     *
     * <code>string agent_Id = 1;</code>
     * @return The bytes for agentId.
     */
    public com.google.protobuf.ByteString
        getAgentIdBytes() {
      java.lang.Object ref = agentId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        agentId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *暂定，id/name/ip等
     * </pre>
     *
     * <code>string agent_Id = 1;</code>
     * @param value The agentId to set.
     * @return This builder for chaining.
     */
    public Builder setAgentId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      agentId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *暂定，id/name/ip等
     * </pre>
     *
     * <code>string agent_Id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearAgentId() {
      
      agentId_ = getDefaultInstance().getAgentId();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *暂定，id/name/ip等
     * </pre>
     *
     * <code>string agent_Id = 1;</code>
     * @param value The bytes for agentId to set.
     * @return This builder for chaining.
     */
    public Builder setAgentIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      agentId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object status_ = "";
    /**
     * <pre>
     *状态，空闲/正在执行任务
     * </pre>
     *
     * <code>string status = 2;</code>
     * @return The status.
     */
    public java.lang.String getStatus() {
      java.lang.Object ref = status_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        status_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *状态，空闲/正在执行任务
     * </pre>
     *
     * <code>string status = 2;</code>
     * @return The bytes for status.
     */
    public com.google.protobuf.ByteString
        getStatusBytes() {
      java.lang.Object ref = status_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        status_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *状态，空闲/正在执行任务
     * </pre>
     *
     * <code>string status = 2;</code>
     * @param value The status to set.
     * @return This builder for chaining.
     */
    public Builder setStatus(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *状态，空闲/正在执行任务
     * </pre>
     *
     * <code>string status = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearStatus() {
      
      status_ = getDefaultInstance().getStatus();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *状态，空闲/正在执行任务
     * </pre>
     *
     * <code>string status = 2;</code>
     * @param value The bytes for status to set.
     * @return This builder for chaining.
     */
    public Builder setStatusBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      status_ = value;
      onChanged();
      return this;
    }

    private java.util.List<com.example.agentgrpc.protocol.collector.TaskList> execList_ =
      java.util.Collections.emptyList();
    private void ensureExecListIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        execList_ = new java.util.ArrayList<com.example.agentgrpc.protocol.collector.TaskList>(execList_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.example.agentgrpc.protocol.collector.TaskList, com.example.agentgrpc.protocol.collector.TaskList.Builder, com.example.agentgrpc.protocol.collector.TaskListOrBuilder> execListBuilder_;

    /**
     * <pre>
     *正在执行的任务列表
     * </pre>
     *
     * <code>repeated .platform.TaskList exec_list = 3;</code>
     */
    public java.util.List<com.example.agentgrpc.protocol.collector.TaskList> getExecListList() {
      if (execListBuilder_ == null) {
        return java.util.Collections.unmodifiableList(execList_);
      } else {
        return execListBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     *正在执行的任务列表
     * </pre>
     *
     * <code>repeated .platform.TaskList exec_list = 3;</code>
     */
    public int getExecListCount() {
      if (execListBuilder_ == null) {
        return execList_.size();
      } else {
        return execListBuilder_.getCount();
      }
    }
    /**
     * <pre>
     *正在执行的任务列表
     * </pre>
     *
     * <code>repeated .platform.TaskList exec_list = 3;</code>
     */
    public com.example.agentgrpc.protocol.collector.TaskList getExecList(int index) {
      if (execListBuilder_ == null) {
        return execList_.get(index);
      } else {
        return execListBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     *正在执行的任务列表
     * </pre>
     *
     * <code>repeated .platform.TaskList exec_list = 3;</code>
     */
    public Builder setExecList(
        int index, com.example.agentgrpc.protocol.collector.TaskList value) {
      if (execListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureExecListIsMutable();
        execList_.set(index, value);
        onChanged();
      } else {
        execListBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     *正在执行的任务列表
     * </pre>
     *
     * <code>repeated .platform.TaskList exec_list = 3;</code>
     */
    public Builder setExecList(
        int index, com.example.agentgrpc.protocol.collector.TaskList.Builder builderForValue) {
      if (execListBuilder_ == null) {
        ensureExecListIsMutable();
        execList_.set(index, builderForValue.build());
        onChanged();
      } else {
        execListBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *正在执行的任务列表
     * </pre>
     *
     * <code>repeated .platform.TaskList exec_list = 3;</code>
     */
    public Builder addExecList(com.example.agentgrpc.protocol.collector.TaskList value) {
      if (execListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureExecListIsMutable();
        execList_.add(value);
        onChanged();
      } else {
        execListBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     *正在执行的任务列表
     * </pre>
     *
     * <code>repeated .platform.TaskList exec_list = 3;</code>
     */
    public Builder addExecList(
        int index, com.example.agentgrpc.protocol.collector.TaskList value) {
      if (execListBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureExecListIsMutable();
        execList_.add(index, value);
        onChanged();
      } else {
        execListBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     *正在执行的任务列表
     * </pre>
     *
     * <code>repeated .platform.TaskList exec_list = 3;</code>
     */
    public Builder addExecList(
        com.example.agentgrpc.protocol.collector.TaskList.Builder builderForValue) {
      if (execListBuilder_ == null) {
        ensureExecListIsMutable();
        execList_.add(builderForValue.build());
        onChanged();
      } else {
        execListBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *正在执行的任务列表
     * </pre>
     *
     * <code>repeated .platform.TaskList exec_list = 3;</code>
     */
    public Builder addExecList(
        int index, com.example.agentgrpc.protocol.collector.TaskList.Builder builderForValue) {
      if (execListBuilder_ == null) {
        ensureExecListIsMutable();
        execList_.add(index, builderForValue.build());
        onChanged();
      } else {
        execListBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *正在执行的任务列表
     * </pre>
     *
     * <code>repeated .platform.TaskList exec_list = 3;</code>
     */
    public Builder addAllExecList(
        java.lang.Iterable<? extends com.example.agentgrpc.protocol.collector.TaskList> values) {
      if (execListBuilder_ == null) {
        ensureExecListIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, execList_);
        onChanged();
      } else {
        execListBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     *正在执行的任务列表
     * </pre>
     *
     * <code>repeated .platform.TaskList exec_list = 3;</code>
     */
    public Builder clearExecList() {
      if (execListBuilder_ == null) {
        execList_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        execListBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     *正在执行的任务列表
     * </pre>
     *
     * <code>repeated .platform.TaskList exec_list = 3;</code>
     */
    public Builder removeExecList(int index) {
      if (execListBuilder_ == null) {
        ensureExecListIsMutable();
        execList_.remove(index);
        onChanged();
      } else {
        execListBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     *正在执行的任务列表
     * </pre>
     *
     * <code>repeated .platform.TaskList exec_list = 3;</code>
     */
    public com.example.agentgrpc.protocol.collector.TaskList.Builder getExecListBuilder(
        int index) {
      return getExecListFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     *正在执行的任务列表
     * </pre>
     *
     * <code>repeated .platform.TaskList exec_list = 3;</code>
     */
    public com.example.agentgrpc.protocol.collector.TaskListOrBuilder getExecListOrBuilder(
        int index) {
      if (execListBuilder_ == null) {
        return execList_.get(index);  } else {
        return execListBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     *正在执行的任务列表
     * </pre>
     *
     * <code>repeated .platform.TaskList exec_list = 3;</code>
     */
    public java.util.List<? extends com.example.agentgrpc.protocol.collector.TaskListOrBuilder> 
         getExecListOrBuilderList() {
      if (execListBuilder_ != null) {
        return execListBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(execList_);
      }
    }
    /**
     * <pre>
     *正在执行的任务列表
     * </pre>
     *
     * <code>repeated .platform.TaskList exec_list = 3;</code>
     */
    public com.example.agentgrpc.protocol.collector.TaskList.Builder addExecListBuilder() {
      return getExecListFieldBuilder().addBuilder(
          com.example.agentgrpc.protocol.collector.TaskList.getDefaultInstance());
    }
    /**
     * <pre>
     *正在执行的任务列表
     * </pre>
     *
     * <code>repeated .platform.TaskList exec_list = 3;</code>
     */
    public com.example.agentgrpc.protocol.collector.TaskList.Builder addExecListBuilder(
        int index) {
      return getExecListFieldBuilder().addBuilder(
          index, com.example.agentgrpc.protocol.collector.TaskList.getDefaultInstance());
    }
    /**
     * <pre>
     *正在执行的任务列表
     * </pre>
     *
     * <code>repeated .platform.TaskList exec_list = 3;</code>
     */
    public java.util.List<com.example.agentgrpc.protocol.collector.TaskList.Builder> 
         getExecListBuilderList() {
      return getExecListFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.example.agentgrpc.protocol.collector.TaskList, com.example.agentgrpc.protocol.collector.TaskList.Builder, com.example.agentgrpc.protocol.collector.TaskListOrBuilder> 
        getExecListFieldBuilder() {
      if (execListBuilder_ == null) {
        execListBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.example.agentgrpc.protocol.collector.TaskList, com.example.agentgrpc.protocol.collector.TaskList.Builder, com.example.agentgrpc.protocol.collector.TaskListOrBuilder>(
                execList_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        execList_ = null;
      }
      return execListBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:platform.AgentStatusReq)
  }

  // @@protoc_insertion_point(class_scope:platform.AgentStatusReq)
  private static final com.example.agentgrpc.protocol.collector.AgentStatusReq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.agentgrpc.protocol.collector.AgentStatusReq();
  }

  public static com.example.agentgrpc.protocol.collector.AgentStatusReq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AgentStatusReq>
      PARSER = new com.google.protobuf.AbstractParser<AgentStatusReq>() {
    @java.lang.Override
    public AgentStatusReq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AgentStatusReq(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AgentStatusReq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AgentStatusReq> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.agentgrpc.protocol.collector.AgentStatusReq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

