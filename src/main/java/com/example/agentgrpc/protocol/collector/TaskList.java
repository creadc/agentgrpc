// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Collector.proto

package com.example.agentgrpc.protocol.collector;

/**
 * Protobuf type {@code platform.TaskList}
 */
public final class TaskList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:platform.TaskList)
    TaskListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TaskList.newBuilder() to construct.
  private TaskList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TaskList() {
    execId_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TaskList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TaskList(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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

            execId_ = s;
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.agentgrpc.protocol.collector.CollectorOuterClass.internal_static_platform_TaskList_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.agentgrpc.protocol.collector.CollectorOuterClass.internal_static_platform_TaskList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.agentgrpc.protocol.collector.TaskList.class, com.example.agentgrpc.protocol.collector.TaskList.Builder.class);
  }

  public static final int EXEC_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object execId_;
  /**
   * <pre>
   *任务id
   * </pre>
   *
   * <code>string exec_id = 1;</code>
   * @return The execId.
   */
  @java.lang.Override
  public java.lang.String getExecId() {
    java.lang.Object ref = execId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      execId_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *任务id
   * </pre>
   *
   * <code>string exec_id = 1;</code>
   * @return The bytes for execId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getExecIdBytes() {
    java.lang.Object ref = execId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      execId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(execId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, execId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(execId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, execId_);
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
    if (!(obj instanceof com.example.agentgrpc.protocol.collector.TaskList)) {
      return super.equals(obj);
    }
    com.example.agentgrpc.protocol.collector.TaskList other = (com.example.agentgrpc.protocol.collector.TaskList) obj;

    if (!getExecId()
        .equals(other.getExecId())) return false;
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
    hash = (37 * hash) + EXEC_ID_FIELD_NUMBER;
    hash = (53 * hash) + getExecId().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.agentgrpc.protocol.collector.TaskList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.agentgrpc.protocol.collector.TaskList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.agentgrpc.protocol.collector.TaskList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.agentgrpc.protocol.collector.TaskList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.agentgrpc.protocol.collector.TaskList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.agentgrpc.protocol.collector.TaskList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.agentgrpc.protocol.collector.TaskList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.agentgrpc.protocol.collector.TaskList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.agentgrpc.protocol.collector.TaskList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.agentgrpc.protocol.collector.TaskList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.agentgrpc.protocol.collector.TaskList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.agentgrpc.protocol.collector.TaskList parseFrom(
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
  public static Builder newBuilder(com.example.agentgrpc.protocol.collector.TaskList prototype) {
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
   * Protobuf type {@code platform.TaskList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:platform.TaskList)
      com.example.agentgrpc.protocol.collector.TaskListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.agentgrpc.protocol.collector.CollectorOuterClass.internal_static_platform_TaskList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.agentgrpc.protocol.collector.CollectorOuterClass.internal_static_platform_TaskList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.agentgrpc.protocol.collector.TaskList.class, com.example.agentgrpc.protocol.collector.TaskList.Builder.class);
    }

    // Construct using com.example.agentgrpc.protocol.collector.TaskList.newBuilder()
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
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      execId_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.agentgrpc.protocol.collector.CollectorOuterClass.internal_static_platform_TaskList_descriptor;
    }

    @java.lang.Override
    public com.example.agentgrpc.protocol.collector.TaskList getDefaultInstanceForType() {
      return com.example.agentgrpc.protocol.collector.TaskList.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.agentgrpc.protocol.collector.TaskList build() {
      com.example.agentgrpc.protocol.collector.TaskList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.agentgrpc.protocol.collector.TaskList buildPartial() {
      com.example.agentgrpc.protocol.collector.TaskList result = new com.example.agentgrpc.protocol.collector.TaskList(this);
      result.execId_ = execId_;
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
      if (other instanceof com.example.agentgrpc.protocol.collector.TaskList) {
        return mergeFrom((com.example.agentgrpc.protocol.collector.TaskList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.agentgrpc.protocol.collector.TaskList other) {
      if (other == com.example.agentgrpc.protocol.collector.TaskList.getDefaultInstance()) return this;
      if (!other.getExecId().isEmpty()) {
        execId_ = other.execId_;
        onChanged();
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
      com.example.agentgrpc.protocol.collector.TaskList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.example.agentgrpc.protocol.collector.TaskList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object execId_ = "";
    /**
     * <pre>
     *任务id
     * </pre>
     *
     * <code>string exec_id = 1;</code>
     * @return The execId.
     */
    public java.lang.String getExecId() {
      java.lang.Object ref = execId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        execId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *任务id
     * </pre>
     *
     * <code>string exec_id = 1;</code>
     * @return The bytes for execId.
     */
    public com.google.protobuf.ByteString
        getExecIdBytes() {
      java.lang.Object ref = execId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        execId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *任务id
     * </pre>
     *
     * <code>string exec_id = 1;</code>
     * @param value The execId to set.
     * @return This builder for chaining.
     */
    public Builder setExecId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      execId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *任务id
     * </pre>
     *
     * <code>string exec_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearExecId() {
      
      execId_ = getDefaultInstance().getExecId();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *任务id
     * </pre>
     *
     * <code>string exec_id = 1;</code>
     * @param value The bytes for execId to set.
     * @return This builder for chaining.
     */
    public Builder setExecIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      execId_ = value;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:platform.TaskList)
  }

  // @@protoc_insertion_point(class_scope:platform.TaskList)
  private static final com.example.agentgrpc.protocol.collector.TaskList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.agentgrpc.protocol.collector.TaskList();
  }

  public static com.example.agentgrpc.protocol.collector.TaskList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TaskList>
      PARSER = new com.google.protobuf.AbstractParser<TaskList>() {
    @java.lang.Override
    public TaskList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TaskList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TaskList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TaskList> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.agentgrpc.protocol.collector.TaskList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

