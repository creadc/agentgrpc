package com.example.agentgrpc.protocol.project;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *agent作为server
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.26.0)",
    comments = "Source: project.proto")
public final class ProjectGrpc {

  private ProjectGrpc() {}

  public static final String SERVICE_NAME = "agent.Project";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.NodeControlReq,
      com.example.agentgrpc.protocol.project.NodeControlRes> getStartNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartNode",
      requestType = com.example.agentgrpc.protocol.project.NodeControlReq.class,
      responseType = com.example.agentgrpc.protocol.project.NodeControlRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.NodeControlReq,
      com.example.agentgrpc.protocol.project.NodeControlRes> getStartNodeMethod() {
    io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.NodeControlReq, com.example.agentgrpc.protocol.project.NodeControlRes> getStartNodeMethod;
    if ((getStartNodeMethod = ProjectGrpc.getStartNodeMethod) == null) {
      synchronized (ProjectGrpc.class) {
        if ((getStartNodeMethod = ProjectGrpc.getStartNodeMethod) == null) {
          ProjectGrpc.getStartNodeMethod = getStartNodeMethod =
              io.grpc.MethodDescriptor.<com.example.agentgrpc.protocol.project.NodeControlReq, com.example.agentgrpc.protocol.project.NodeControlRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartNode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.project.NodeControlReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.project.NodeControlRes.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectMethodDescriptorSupplier("StartNode"))
              .build();
        }
      }
    }
    return getStartNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.NodeControlReq,
      com.example.agentgrpc.protocol.project.NodeControlRes> getStopNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopNode",
      requestType = com.example.agentgrpc.protocol.project.NodeControlReq.class,
      responseType = com.example.agentgrpc.protocol.project.NodeControlRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.NodeControlReq,
      com.example.agentgrpc.protocol.project.NodeControlRes> getStopNodeMethod() {
    io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.NodeControlReq, com.example.agentgrpc.protocol.project.NodeControlRes> getStopNodeMethod;
    if ((getStopNodeMethod = ProjectGrpc.getStopNodeMethod) == null) {
      synchronized (ProjectGrpc.class) {
        if ((getStopNodeMethod = ProjectGrpc.getStopNodeMethod) == null) {
          ProjectGrpc.getStopNodeMethod = getStopNodeMethod =
              io.grpc.MethodDescriptor.<com.example.agentgrpc.protocol.project.NodeControlReq, com.example.agentgrpc.protocol.project.NodeControlRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopNode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.project.NodeControlReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.project.NodeControlRes.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectMethodDescriptorSupplier("StopNode"))
              .build();
        }
      }
    }
    return getStopNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.NodeControlReq,
      com.example.agentgrpc.protocol.project.NodeControlRes> getReStartNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReStartNode",
      requestType = com.example.agentgrpc.protocol.project.NodeControlReq.class,
      responseType = com.example.agentgrpc.protocol.project.NodeControlRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.NodeControlReq,
      com.example.agentgrpc.protocol.project.NodeControlRes> getReStartNodeMethod() {
    io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.NodeControlReq, com.example.agentgrpc.protocol.project.NodeControlRes> getReStartNodeMethod;
    if ((getReStartNodeMethod = ProjectGrpc.getReStartNodeMethod) == null) {
      synchronized (ProjectGrpc.class) {
        if ((getReStartNodeMethod = ProjectGrpc.getReStartNodeMethod) == null) {
          ProjectGrpc.getReStartNodeMethod = getReStartNodeMethod =
              io.grpc.MethodDescriptor.<com.example.agentgrpc.protocol.project.NodeControlReq, com.example.agentgrpc.protocol.project.NodeControlRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReStartNode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.project.NodeControlReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.project.NodeControlRes.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectMethodDescriptorSupplier("ReStartNode"))
              .build();
        }
      }
    }
    return getReStartNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.ReplaceJarReq,
      com.example.agentgrpc.protocol.project.NodeControlRes> getReplaceJarMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReplaceJar",
      requestType = com.example.agentgrpc.protocol.project.ReplaceJarReq.class,
      responseType = com.example.agentgrpc.protocol.project.NodeControlRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.ReplaceJarReq,
      com.example.agentgrpc.protocol.project.NodeControlRes> getReplaceJarMethod() {
    io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.ReplaceJarReq, com.example.agentgrpc.protocol.project.NodeControlRes> getReplaceJarMethod;
    if ((getReplaceJarMethod = ProjectGrpc.getReplaceJarMethod) == null) {
      synchronized (ProjectGrpc.class) {
        if ((getReplaceJarMethod = ProjectGrpc.getReplaceJarMethod) == null) {
          ProjectGrpc.getReplaceJarMethod = getReplaceJarMethod =
              io.grpc.MethodDescriptor.<com.example.agentgrpc.protocol.project.ReplaceJarReq, com.example.agentgrpc.protocol.project.NodeControlRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReplaceJar"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.project.ReplaceJarReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.project.NodeControlRes.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectMethodDescriptorSupplier("ReplaceJar"))
              .build();
        }
      }
    }
    return getReplaceJarMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.NodeControlReq,
      com.example.agentgrpc.protocol.project.NodeStateRes> getNodeStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "NodeState",
      requestType = com.example.agentgrpc.protocol.project.NodeControlReq.class,
      responseType = com.example.agentgrpc.protocol.project.NodeStateRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.NodeControlReq,
      com.example.agentgrpc.protocol.project.NodeStateRes> getNodeStateMethod() {
    io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.NodeControlReq, com.example.agentgrpc.protocol.project.NodeStateRes> getNodeStateMethod;
    if ((getNodeStateMethod = ProjectGrpc.getNodeStateMethod) == null) {
      synchronized (ProjectGrpc.class) {
        if ((getNodeStateMethod = ProjectGrpc.getNodeStateMethod) == null) {
          ProjectGrpc.getNodeStateMethod = getNodeStateMethod =
              io.grpc.MethodDescriptor.<com.example.agentgrpc.protocol.project.NodeControlReq, com.example.agentgrpc.protocol.project.NodeStateRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "NodeState"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.project.NodeControlReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.project.NodeStateRes.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectMethodDescriptorSupplier("NodeState"))
              .build();
        }
      }
    }
    return getNodeStateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.PrintStacksReq,
      com.example.agentgrpc.protocol.project.NodeControlRes> getStartPrintJStacksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartPrintJStacks",
      requestType = com.example.agentgrpc.protocol.project.PrintStacksReq.class,
      responseType = com.example.agentgrpc.protocol.project.NodeControlRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.PrintStacksReq,
      com.example.agentgrpc.protocol.project.NodeControlRes> getStartPrintJStacksMethod() {
    io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.PrintStacksReq, com.example.agentgrpc.protocol.project.NodeControlRes> getStartPrintJStacksMethod;
    if ((getStartPrintJStacksMethod = ProjectGrpc.getStartPrintJStacksMethod) == null) {
      synchronized (ProjectGrpc.class) {
        if ((getStartPrintJStacksMethod = ProjectGrpc.getStartPrintJStacksMethod) == null) {
          ProjectGrpc.getStartPrintJStacksMethod = getStartPrintJStacksMethod =
              io.grpc.MethodDescriptor.<com.example.agentgrpc.protocol.project.PrintStacksReq, com.example.agentgrpc.protocol.project.NodeControlRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartPrintJStacks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.project.PrintStacksReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.project.NodeControlRes.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectMethodDescriptorSupplier("StartPrintJStacks"))
              .build();
        }
      }
    }
    return getStartPrintJStacksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.NodeControlReq,
      com.example.agentgrpc.protocol.project.StopPrintJStacksRes> getStopPrintJStacksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopPrintJStacks",
      requestType = com.example.agentgrpc.protocol.project.NodeControlReq.class,
      responseType = com.example.agentgrpc.protocol.project.StopPrintJStacksRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.NodeControlReq,
      com.example.agentgrpc.protocol.project.StopPrintJStacksRes> getStopPrintJStacksMethod() {
    io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.NodeControlReq, com.example.agentgrpc.protocol.project.StopPrintJStacksRes> getStopPrintJStacksMethod;
    if ((getStopPrintJStacksMethod = ProjectGrpc.getStopPrintJStacksMethod) == null) {
      synchronized (ProjectGrpc.class) {
        if ((getStopPrintJStacksMethod = ProjectGrpc.getStopPrintJStacksMethod) == null) {
          ProjectGrpc.getStopPrintJStacksMethod = getStopPrintJStacksMethod =
              io.grpc.MethodDescriptor.<com.example.agentgrpc.protocol.project.NodeControlReq, com.example.agentgrpc.protocol.project.StopPrintJStacksRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopPrintJStacks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.project.NodeControlReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.project.StopPrintJStacksRes.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectMethodDescriptorSupplier("StopPrintJStacks"))
              .build();
        }
      }
    }
    return getStopPrintJStacksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.NodeControlReq,
      com.example.agentgrpc.protocol.project.NodeControlRes> getPrintDumpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PrintDump",
      requestType = com.example.agentgrpc.protocol.project.NodeControlReq.class,
      responseType = com.example.agentgrpc.protocol.project.NodeControlRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.NodeControlReq,
      com.example.agentgrpc.protocol.project.NodeControlRes> getPrintDumpMethod() {
    io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.project.NodeControlReq, com.example.agentgrpc.protocol.project.NodeControlRes> getPrintDumpMethod;
    if ((getPrintDumpMethod = ProjectGrpc.getPrintDumpMethod) == null) {
      synchronized (ProjectGrpc.class) {
        if ((getPrintDumpMethod = ProjectGrpc.getPrintDumpMethod) == null) {
          ProjectGrpc.getPrintDumpMethod = getPrintDumpMethod =
              io.grpc.MethodDescriptor.<com.example.agentgrpc.protocol.project.NodeControlReq, com.example.agentgrpc.protocol.project.NodeControlRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PrintDump"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.project.NodeControlReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.project.NodeControlRes.getDefaultInstance()))
              .setSchemaDescriptor(new ProjectMethodDescriptorSupplier("PrintDump"))
              .build();
        }
      }
    }
    return getPrintDumpMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProjectStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProjectStub>() {
        @java.lang.Override
        public ProjectStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProjectStub(channel, callOptions);
        }
      };
    return ProjectStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProjectBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProjectBlockingStub>() {
        @java.lang.Override
        public ProjectBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProjectBlockingStub(channel, callOptions);
        }
      };
    return ProjectBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProjectFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProjectFutureStub>() {
        @java.lang.Override
        public ProjectFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProjectFutureStub(channel, callOptions);
        }
      };
    return ProjectFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *agent作为server
   * </pre>
   */
  public static abstract class ProjectImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *启动工程
     * </pre>
     */
    public void startNode(com.example.agentgrpc.protocol.project.NodeControlReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeControlRes> responseObserver) {
      asyncUnimplementedUnaryCall(getStartNodeMethod(), responseObserver);
    }

    /**
     * <pre>
     *停止工程
     * </pre>
     */
    public void stopNode(com.example.agentgrpc.protocol.project.NodeControlReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeControlRes> responseObserver) {
      asyncUnimplementedUnaryCall(getStopNodeMethod(), responseObserver);
    }

    /**
     * <pre>
     *重启工程
     * </pre>
     */
    public void reStartNode(com.example.agentgrpc.protocol.project.NodeControlReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeControlRes> responseObserver) {
      asyncUnimplementedUnaryCall(getReStartNodeMethod(), responseObserver);
    }

    /**
     * <pre>
     *换jar
     * </pre>
     */
    public void replaceJar(com.example.agentgrpc.protocol.project.ReplaceJarReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeControlRes> responseObserver) {
      asyncUnimplementedUnaryCall(getReplaceJarMethod(), responseObserver);
    }

    /**
     * <pre>
     *节点状态
     * </pre>
     */
    public void nodeState(com.example.agentgrpc.protocol.project.NodeControlReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeStateRes> responseObserver) {
      asyncUnimplementedUnaryCall(getNodeStateMethod(), responseObserver);
    }

    /**
     * <pre>
     *持续打堆栈
     * </pre>
     */
    public void startPrintJStacks(com.example.agentgrpc.protocol.project.PrintStacksReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeControlRes> responseObserver) {
      asyncUnimplementedUnaryCall(getStartPrintJStacksMethod(), responseObserver);
    }

    /**
     * <pre>
     *停止打堆栈
     * </pre>
     */
    public void stopPrintJStacks(com.example.agentgrpc.protocol.project.NodeControlReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.StopPrintJStacksRes> responseObserver) {
      asyncUnimplementedUnaryCall(getStopPrintJStacksMethod(), responseObserver);
    }

    /**
     * <pre>
     *打dump
     * </pre>
     */
    public void printDump(com.example.agentgrpc.protocol.project.NodeControlReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeControlRes> responseObserver) {
      asyncUnimplementedUnaryCall(getPrintDumpMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStartNodeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.agentgrpc.protocol.project.NodeControlReq,
                com.example.agentgrpc.protocol.project.NodeControlRes>(
                  this, METHODID_START_NODE)))
          .addMethod(
            getStopNodeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.agentgrpc.protocol.project.NodeControlReq,
                com.example.agentgrpc.protocol.project.NodeControlRes>(
                  this, METHODID_STOP_NODE)))
          .addMethod(
            getReStartNodeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.agentgrpc.protocol.project.NodeControlReq,
                com.example.agentgrpc.protocol.project.NodeControlRes>(
                  this, METHODID_RE_START_NODE)))
          .addMethod(
            getReplaceJarMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.agentgrpc.protocol.project.ReplaceJarReq,
                com.example.agentgrpc.protocol.project.NodeControlRes>(
                  this, METHODID_REPLACE_JAR)))
          .addMethod(
            getNodeStateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.agentgrpc.protocol.project.NodeControlReq,
                com.example.agentgrpc.protocol.project.NodeStateRes>(
                  this, METHODID_NODE_STATE)))
          .addMethod(
            getStartPrintJStacksMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.agentgrpc.protocol.project.PrintStacksReq,
                com.example.agentgrpc.protocol.project.NodeControlRes>(
                  this, METHODID_START_PRINT_JSTACKS)))
          .addMethod(
            getStopPrintJStacksMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.example.agentgrpc.protocol.project.NodeControlReq,
                com.example.agentgrpc.protocol.project.StopPrintJStacksRes>(
                  this, METHODID_STOP_PRINT_JSTACKS)))
          .addMethod(
            getPrintDumpMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.agentgrpc.protocol.project.NodeControlReq,
                com.example.agentgrpc.protocol.project.NodeControlRes>(
                  this, METHODID_PRINT_DUMP)))
          .build();
    }
  }

  /**
   * <pre>
   *agent作为server
   * </pre>
   */
  public static final class ProjectStub extends io.grpc.stub.AbstractAsyncStub<ProjectStub> {
    private ProjectStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectStub(channel, callOptions);
    }

    /**
     * <pre>
     *启动工程
     * </pre>
     */
    public void startNode(com.example.agentgrpc.protocol.project.NodeControlReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeControlRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStartNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *停止工程
     * </pre>
     */
    public void stopNode(com.example.agentgrpc.protocol.project.NodeControlReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeControlRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStopNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *重启工程
     * </pre>
     */
    public void reStartNode(com.example.agentgrpc.protocol.project.NodeControlReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeControlRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReStartNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *换jar
     * </pre>
     */
    public void replaceJar(com.example.agentgrpc.protocol.project.ReplaceJarReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeControlRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReplaceJarMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *节点状态
     * </pre>
     */
    public void nodeState(com.example.agentgrpc.protocol.project.NodeControlReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeStateRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getNodeStateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *持续打堆栈
     * </pre>
     */
    public void startPrintJStacks(com.example.agentgrpc.protocol.project.PrintStacksReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeControlRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStartPrintJStacksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *停止打堆栈
     * </pre>
     */
    public void stopPrintJStacks(com.example.agentgrpc.protocol.project.NodeControlReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.StopPrintJStacksRes> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStopPrintJStacksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *打dump
     * </pre>
     */
    public void printDump(com.example.agentgrpc.protocol.project.NodeControlReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeControlRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPrintDumpMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *agent作为server
   * </pre>
   */
  public static final class ProjectBlockingStub extends io.grpc.stub.AbstractBlockingStub<ProjectBlockingStub> {
    private ProjectBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *启动工程
     * </pre>
     */
    public com.example.agentgrpc.protocol.project.NodeControlRes startNode(com.example.agentgrpc.protocol.project.NodeControlReq request) {
      return blockingUnaryCall(
          getChannel(), getStartNodeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *停止工程
     * </pre>
     */
    public com.example.agentgrpc.protocol.project.NodeControlRes stopNode(com.example.agentgrpc.protocol.project.NodeControlReq request) {
      return blockingUnaryCall(
          getChannel(), getStopNodeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *重启工程
     * </pre>
     */
    public com.example.agentgrpc.protocol.project.NodeControlRes reStartNode(com.example.agentgrpc.protocol.project.NodeControlReq request) {
      return blockingUnaryCall(
          getChannel(), getReStartNodeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *换jar
     * </pre>
     */
    public com.example.agentgrpc.protocol.project.NodeControlRes replaceJar(com.example.agentgrpc.protocol.project.ReplaceJarReq request) {
      return blockingUnaryCall(
          getChannel(), getReplaceJarMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *节点状态
     * </pre>
     */
    public com.example.agentgrpc.protocol.project.NodeStateRes nodeState(com.example.agentgrpc.protocol.project.NodeControlReq request) {
      return blockingUnaryCall(
          getChannel(), getNodeStateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *持续打堆栈
     * </pre>
     */
    public com.example.agentgrpc.protocol.project.NodeControlRes startPrintJStacks(com.example.agentgrpc.protocol.project.PrintStacksReq request) {
      return blockingUnaryCall(
          getChannel(), getStartPrintJStacksMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *停止打堆栈
     * </pre>
     */
    public java.util.Iterator<com.example.agentgrpc.protocol.project.StopPrintJStacksRes> stopPrintJStacks(
        com.example.agentgrpc.protocol.project.NodeControlReq request) {
      return blockingServerStreamingCall(
          getChannel(), getStopPrintJStacksMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *打dump
     * </pre>
     */
    public com.example.agentgrpc.protocol.project.NodeControlRes printDump(com.example.agentgrpc.protocol.project.NodeControlReq request) {
      return blockingUnaryCall(
          getChannel(), getPrintDumpMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *agent作为server
   * </pre>
   */
  public static final class ProjectFutureStub extends io.grpc.stub.AbstractFutureStub<ProjectFutureStub> {
    private ProjectFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *启动工程
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.agentgrpc.protocol.project.NodeControlRes> startNode(
        com.example.agentgrpc.protocol.project.NodeControlReq request) {
      return futureUnaryCall(
          getChannel().newCall(getStartNodeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *停止工程
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.agentgrpc.protocol.project.NodeControlRes> stopNode(
        com.example.agentgrpc.protocol.project.NodeControlReq request) {
      return futureUnaryCall(
          getChannel().newCall(getStopNodeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *重启工程
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.agentgrpc.protocol.project.NodeControlRes> reStartNode(
        com.example.agentgrpc.protocol.project.NodeControlReq request) {
      return futureUnaryCall(
          getChannel().newCall(getReStartNodeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *换jar
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.agentgrpc.protocol.project.NodeControlRes> replaceJar(
        com.example.agentgrpc.protocol.project.ReplaceJarReq request) {
      return futureUnaryCall(
          getChannel().newCall(getReplaceJarMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *节点状态
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.agentgrpc.protocol.project.NodeStateRes> nodeState(
        com.example.agentgrpc.protocol.project.NodeControlReq request) {
      return futureUnaryCall(
          getChannel().newCall(getNodeStateMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *持续打堆栈
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.agentgrpc.protocol.project.NodeControlRes> startPrintJStacks(
        com.example.agentgrpc.protocol.project.PrintStacksReq request) {
      return futureUnaryCall(
          getChannel().newCall(getStartPrintJStacksMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *打dump
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.agentgrpc.protocol.project.NodeControlRes> printDump(
        com.example.agentgrpc.protocol.project.NodeControlReq request) {
      return futureUnaryCall(
          getChannel().newCall(getPrintDumpMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_START_NODE = 0;
  private static final int METHODID_STOP_NODE = 1;
  private static final int METHODID_RE_START_NODE = 2;
  private static final int METHODID_REPLACE_JAR = 3;
  private static final int METHODID_NODE_STATE = 4;
  private static final int METHODID_START_PRINT_JSTACKS = 5;
  private static final int METHODID_STOP_PRINT_JSTACKS = 6;
  private static final int METHODID_PRINT_DUMP = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProjectImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProjectImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_START_NODE:
          serviceImpl.startNode((com.example.agentgrpc.protocol.project.NodeControlReq) request,
              (io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeControlRes>) responseObserver);
          break;
        case METHODID_STOP_NODE:
          serviceImpl.stopNode((com.example.agentgrpc.protocol.project.NodeControlReq) request,
              (io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeControlRes>) responseObserver);
          break;
        case METHODID_RE_START_NODE:
          serviceImpl.reStartNode((com.example.agentgrpc.protocol.project.NodeControlReq) request,
              (io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeControlRes>) responseObserver);
          break;
        case METHODID_REPLACE_JAR:
          serviceImpl.replaceJar((com.example.agentgrpc.protocol.project.ReplaceJarReq) request,
              (io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeControlRes>) responseObserver);
          break;
        case METHODID_NODE_STATE:
          serviceImpl.nodeState((com.example.agentgrpc.protocol.project.NodeControlReq) request,
              (io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeStateRes>) responseObserver);
          break;
        case METHODID_START_PRINT_JSTACKS:
          serviceImpl.startPrintJStacks((com.example.agentgrpc.protocol.project.PrintStacksReq) request,
              (io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeControlRes>) responseObserver);
          break;
        case METHODID_STOP_PRINT_JSTACKS:
          serviceImpl.stopPrintJStacks((com.example.agentgrpc.protocol.project.NodeControlReq) request,
              (io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.StopPrintJStacksRes>) responseObserver);
          break;
        case METHODID_PRINT_DUMP:
          serviceImpl.printDump((com.example.agentgrpc.protocol.project.NodeControlReq) request,
              (io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.project.NodeControlRes>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ProjectBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProjectBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.agentgrpc.protocol.project.ProjectOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Project");
    }
  }

  private static final class ProjectFileDescriptorSupplier
      extends ProjectBaseDescriptorSupplier {
    ProjectFileDescriptorSupplier() {}
  }

  private static final class ProjectMethodDescriptorSupplier
      extends ProjectBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProjectMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProjectGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProjectFileDescriptorSupplier())
              .addMethod(getStartNodeMethod())
              .addMethod(getStopNodeMethod())
              .addMethod(getReStartNodeMethod())
              .addMethod(getReplaceJarMethod())
              .addMethod(getNodeStateMethod())
              .addMethod(getStartPrintJStacksMethod())
              .addMethod(getStopPrintJStacksMethod())
              .addMethod(getPrintDumpMethod())
              .build();
        }
      }
    }
    return result;
  }
}
