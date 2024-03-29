// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: project.proto

package com.example.agentgrpc.protocol.project;

/**
 * Protobuf type {@code agent.NodeStateRes}
 */
public final class NodeStateRes extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:agent.NodeStateRes)
    NodeStateResOrBuilder {
private static final long serialVersionUID = 0L;
  // Use NodeStateRes.newBuilder() to construct.
  private NodeStateRes(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NodeStateRes() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new NodeStateRes();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private NodeStateRes(
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
          case 8: {

            code_ = input.readInt32();
            break;
          }
          case 16: {

            isUp_ = input.readInt32();
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              attrs_ = com.google.protobuf.MapField.newMapField(
                  AttrsDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000001;
            }
            com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
            attrs__ = input.readMessage(
                AttrsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            attrs_.getMutableMap().put(
                attrs__.getKey(), attrs__.getValue());
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
    return com.example.agentgrpc.protocol.project.ProjectOuterClass.internal_static_agent_NodeStateRes_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @java.lang.Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 3:
        return internalGetAttrs();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.agentgrpc.protocol.project.ProjectOuterClass.internal_static_agent_NodeStateRes_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.agentgrpc.protocol.project.NodeStateRes.class, com.example.agentgrpc.protocol.project.NodeStateRes.Builder.class);
  }

  public static final int CODE_FIELD_NUMBER = 1;
  private int code_;
  /**
   * <pre>
   *执行状态，0成功-1失败-2执行中
   * </pre>
   *
   * <code>int32 code = 1;</code>
   * @return The code.
   */
  @java.lang.Override
  public int getCode() {
    return code_;
  }

  public static final int IS_UP_FIELD_NUMBER = 2;
  private int isUp_;
  /**
   * <pre>
   *是否在线 0在线-1不在线-2(可以增加)宕机
   * </pre>
   *
   * <code>int32 is_up = 2;</code>
   * @return The isUp.
   */
  @java.lang.Override
  public int getIsUp() {
    return isUp_;
  }

  public static final int ATTRS_FIELD_NUMBER = 3;
  private static final class AttrsDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.String, java.lang.String> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.String, java.lang.String>newDefaultInstance(
                com.example.agentgrpc.protocol.project.ProjectOuterClass.internal_static_agent_NodeStateRes_AttrsEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.STRING,
                "");
  }
  private com.google.protobuf.MapField<
      java.lang.String, java.lang.String> attrs_;
  private com.google.protobuf.MapField<java.lang.String, java.lang.String>
  internalGetAttrs() {
    if (attrs_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          AttrsDefaultEntryHolder.defaultEntry);
    }
    return attrs_;
  }

  public int getAttrsCount() {
    return internalGetAttrs().getMap().size();
  }
  /**
   * <pre>
   *其他属性，如jar_time
   * </pre>
   *
   * <code>map&lt;string, string&gt; attrs = 3;</code>
   */

  @java.lang.Override
  public boolean containsAttrs(
      java.lang.String key) {
    if (key == null) { throw new NullPointerException("map key"); }
    return internalGetAttrs().getMap().containsKey(key);
  }
  /**
   * Use {@link #getAttrsMap()} instead.
   */
  @java.lang.Override
  @java.lang.Deprecated
  public java.util.Map<java.lang.String, java.lang.String> getAttrs() {
    return getAttrsMap();
  }
  /**
   * <pre>
   *其他属性，如jar_time
   * </pre>
   *
   * <code>map&lt;string, string&gt; attrs = 3;</code>
   */
  @java.lang.Override

  public java.util.Map<java.lang.String, java.lang.String> getAttrsMap() {
    return internalGetAttrs().getMap();
  }
  /**
   * <pre>
   *其他属性，如jar_time
   * </pre>
   *
   * <code>map&lt;string, string&gt; attrs = 3;</code>
   */
  @java.lang.Override

  public java.lang.String getAttrsOrDefault(
      java.lang.String key,
      java.lang.String defaultValue) {
    if (key == null) { throw new NullPointerException("map key"); }
    java.util.Map<java.lang.String, java.lang.String> map =
        internalGetAttrs().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <pre>
   *其他属性，如jar_time
   * </pre>
   *
   * <code>map&lt;string, string&gt; attrs = 3;</code>
   */
  @java.lang.Override

  public java.lang.String getAttrsOrThrow(
      java.lang.String key) {
    if (key == null) { throw new NullPointerException("map key"); }
    java.util.Map<java.lang.String, java.lang.String> map =
        internalGetAttrs().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
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
    if (code_ != 0) {
      output.writeInt32(1, code_);
    }
    if (isUp_ != 0) {
      output.writeInt32(2, isUp_);
    }
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetAttrs(),
        AttrsDefaultEntryHolder.defaultEntry,
        3);
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (code_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, code_);
    }
    if (isUp_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, isUp_);
    }
    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
         : internalGetAttrs().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
      attrs__ = AttrsDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, attrs__);
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
    if (!(obj instanceof com.example.agentgrpc.protocol.project.NodeStateRes)) {
      return super.equals(obj);
    }
    com.example.agentgrpc.protocol.project.NodeStateRes other = (com.example.agentgrpc.protocol.project.NodeStateRes) obj;

    if (getCode()
        != other.getCode()) return false;
    if (getIsUp()
        != other.getIsUp()) return false;
    if (!internalGetAttrs().equals(
        other.internalGetAttrs())) return false;
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
    hash = (37 * hash) + CODE_FIELD_NUMBER;
    hash = (53 * hash) + getCode();
    hash = (37 * hash) + IS_UP_FIELD_NUMBER;
    hash = (53 * hash) + getIsUp();
    if (!internalGetAttrs().getMap().isEmpty()) {
      hash = (37 * hash) + ATTRS_FIELD_NUMBER;
      hash = (53 * hash) + internalGetAttrs().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.agentgrpc.protocol.project.NodeStateRes parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.agentgrpc.protocol.project.NodeStateRes parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.agentgrpc.protocol.project.NodeStateRes parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.agentgrpc.protocol.project.NodeStateRes parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.agentgrpc.protocol.project.NodeStateRes parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.agentgrpc.protocol.project.NodeStateRes parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.agentgrpc.protocol.project.NodeStateRes parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.agentgrpc.protocol.project.NodeStateRes parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.agentgrpc.protocol.project.NodeStateRes parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.agentgrpc.protocol.project.NodeStateRes parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.agentgrpc.protocol.project.NodeStateRes parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.agentgrpc.protocol.project.NodeStateRes parseFrom(
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
  public static Builder newBuilder(com.example.agentgrpc.protocol.project.NodeStateRes prototype) {
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
   * Protobuf type {@code agent.NodeStateRes}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:agent.NodeStateRes)
      com.example.agentgrpc.protocol.project.NodeStateResOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.agentgrpc.protocol.project.ProjectOuterClass.internal_static_agent_NodeStateRes_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 3:
          return internalGetAttrs();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 3:
          return internalGetMutableAttrs();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.agentgrpc.protocol.project.ProjectOuterClass.internal_static_agent_NodeStateRes_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.agentgrpc.protocol.project.NodeStateRes.class, com.example.agentgrpc.protocol.project.NodeStateRes.Builder.class);
    }

    // Construct using com.example.agentgrpc.protocol.project.NodeStateRes.newBuilder()
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
      code_ = 0;

      isUp_ = 0;

      internalGetMutableAttrs().clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.agentgrpc.protocol.project.ProjectOuterClass.internal_static_agent_NodeStateRes_descriptor;
    }

    @java.lang.Override
    public com.example.agentgrpc.protocol.project.NodeStateRes getDefaultInstanceForType() {
      return com.example.agentgrpc.protocol.project.NodeStateRes.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.agentgrpc.protocol.project.NodeStateRes build() {
      com.example.agentgrpc.protocol.project.NodeStateRes result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.agentgrpc.protocol.project.NodeStateRes buildPartial() {
      com.example.agentgrpc.protocol.project.NodeStateRes result = new com.example.agentgrpc.protocol.project.NodeStateRes(this);
      int from_bitField0_ = bitField0_;
      result.code_ = code_;
      result.isUp_ = isUp_;
      result.attrs_ = internalGetAttrs();
      result.attrs_.makeImmutable();
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
      if (other instanceof com.example.agentgrpc.protocol.project.NodeStateRes) {
        return mergeFrom((com.example.agentgrpc.protocol.project.NodeStateRes)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.agentgrpc.protocol.project.NodeStateRes other) {
      if (other == com.example.agentgrpc.protocol.project.NodeStateRes.getDefaultInstance()) return this;
      if (other.getCode() != 0) {
        setCode(other.getCode());
      }
      if (other.getIsUp() != 0) {
        setIsUp(other.getIsUp());
      }
      internalGetMutableAttrs().mergeFrom(
          other.internalGetAttrs());
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
      com.example.agentgrpc.protocol.project.NodeStateRes parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.example.agentgrpc.protocol.project.NodeStateRes) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int code_ ;
    /**
     * <pre>
     *执行状态，0成功-1失败-2执行中
     * </pre>
     *
     * <code>int32 code = 1;</code>
     * @return The code.
     */
    @java.lang.Override
    public int getCode() {
      return code_;
    }
    /**
     * <pre>
     *执行状态，0成功-1失败-2执行中
     * </pre>
     *
     * <code>int32 code = 1;</code>
     * @param value The code to set.
     * @return This builder for chaining.
     */
    public Builder setCode(int value) {
      
      code_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *执行状态，0成功-1失败-2执行中
     * </pre>
     *
     * <code>int32 code = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCode() {
      
      code_ = 0;
      onChanged();
      return this;
    }

    private int isUp_ ;
    /**
     * <pre>
     *是否在线 0在线-1不在线-2(可以增加)宕机
     * </pre>
     *
     * <code>int32 is_up = 2;</code>
     * @return The isUp.
     */
    @java.lang.Override
    public int getIsUp() {
      return isUp_;
    }
    /**
     * <pre>
     *是否在线 0在线-1不在线-2(可以增加)宕机
     * </pre>
     *
     * <code>int32 is_up = 2;</code>
     * @param value The isUp to set.
     * @return This builder for chaining.
     */
    public Builder setIsUp(int value) {
      
      isUp_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *是否在线 0在线-1不在线-2(可以增加)宕机
     * </pre>
     *
     * <code>int32 is_up = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearIsUp() {
      
      isUp_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.MapField<
        java.lang.String, java.lang.String> attrs_;
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetAttrs() {
      if (attrs_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            AttrsDefaultEntryHolder.defaultEntry);
      }
      return attrs_;
    }
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetMutableAttrs() {
      onChanged();;
      if (attrs_ == null) {
        attrs_ = com.google.protobuf.MapField.newMapField(
            AttrsDefaultEntryHolder.defaultEntry);
      }
      if (!attrs_.isMutable()) {
        attrs_ = attrs_.copy();
      }
      return attrs_;
    }

    public int getAttrsCount() {
      return internalGetAttrs().getMap().size();
    }
    /**
     * <pre>
     *其他属性，如jar_time
     * </pre>
     *
     * <code>map&lt;string, string&gt; attrs = 3;</code>
     */

    @java.lang.Override
    public boolean containsAttrs(
        java.lang.String key) {
      if (key == null) { throw new NullPointerException("map key"); }
      return internalGetAttrs().getMap().containsKey(key);
    }
    /**
     * Use {@link #getAttrsMap()} instead.
     */
    @java.lang.Override
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String> getAttrs() {
      return getAttrsMap();
    }
    /**
     * <pre>
     *其他属性，如jar_time
     * </pre>
     *
     * <code>map&lt;string, string&gt; attrs = 3;</code>
     */
    @java.lang.Override

    public java.util.Map<java.lang.String, java.lang.String> getAttrsMap() {
      return internalGetAttrs().getMap();
    }
    /**
     * <pre>
     *其他属性，如jar_time
     * </pre>
     *
     * <code>map&lt;string, string&gt; attrs = 3;</code>
     */
    @java.lang.Override

    public java.lang.String getAttrsOrDefault(
        java.lang.String key,
        java.lang.String defaultValue) {
      if (key == null) { throw new NullPointerException("map key"); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetAttrs().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <pre>
     *其他属性，如jar_time
     * </pre>
     *
     * <code>map&lt;string, string&gt; attrs = 3;</code>
     */
    @java.lang.Override

    public java.lang.String getAttrsOrThrow(
        java.lang.String key) {
      if (key == null) { throw new NullPointerException("map key"); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetAttrs().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearAttrs() {
      internalGetMutableAttrs().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <pre>
     *其他属性，如jar_time
     * </pre>
     *
     * <code>map&lt;string, string&gt; attrs = 3;</code>
     */

    public Builder removeAttrs(
        java.lang.String key) {
      if (key == null) { throw new NullPointerException("map key"); }
      internalGetMutableAttrs().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String>
    getMutableAttrs() {
      return internalGetMutableAttrs().getMutableMap();
    }
    /**
     * <pre>
     *其他属性，如jar_time
     * </pre>
     *
     * <code>map&lt;string, string&gt; attrs = 3;</code>
     */
    public Builder putAttrs(
        java.lang.String key,
        java.lang.String value) {
      if (key == null) { throw new NullPointerException("map key"); }
      if (value == null) {
  throw new NullPointerException("map value");
}

      internalGetMutableAttrs().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <pre>
     *其他属性，如jar_time
     * </pre>
     *
     * <code>map&lt;string, string&gt; attrs = 3;</code>
     */

    public Builder putAllAttrs(
        java.util.Map<java.lang.String, java.lang.String> values) {
      internalGetMutableAttrs().getMutableMap()
          .putAll(values);
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


    // @@protoc_insertion_point(builder_scope:agent.NodeStateRes)
  }

  // @@protoc_insertion_point(class_scope:agent.NodeStateRes)
  private static final com.example.agentgrpc.protocol.project.NodeStateRes DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.agentgrpc.protocol.project.NodeStateRes();
  }

  public static com.example.agentgrpc.protocol.project.NodeStateRes getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NodeStateRes>
      PARSER = new com.google.protobuf.AbstractParser<NodeStateRes>() {
    @java.lang.Override
    public NodeStateRes parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new NodeStateRes(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NodeStateRes> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<NodeStateRes> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.agentgrpc.protocol.project.NodeStateRes getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

