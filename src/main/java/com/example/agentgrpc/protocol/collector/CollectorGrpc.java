package com.example.agentgrpc.protocol.collector;

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
 *中心节点作为server
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.26.0)",
    comments = "Source: Collector.proto")
public final class CollectorGrpc {

  private CollectorGrpc() {}

  public static final String SERVICE_NAME = "platform.Collector";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.collector.AgentStatusReq,
      com.example.agentgrpc.protocol.collector.AgentStatusRes> getAgentStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AgentStatus",
      requestType = com.example.agentgrpc.protocol.collector.AgentStatusReq.class,
      responseType = com.example.agentgrpc.protocol.collector.AgentStatusRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.collector.AgentStatusReq,
      com.example.agentgrpc.protocol.collector.AgentStatusRes> getAgentStatusMethod() {
    io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.collector.AgentStatusReq, com.example.agentgrpc.protocol.collector.AgentStatusRes> getAgentStatusMethod;
    if ((getAgentStatusMethod = CollectorGrpc.getAgentStatusMethod) == null) {
      synchronized (CollectorGrpc.class) {
        if ((getAgentStatusMethod = CollectorGrpc.getAgentStatusMethod) == null) {
          CollectorGrpc.getAgentStatusMethod = getAgentStatusMethod =
              io.grpc.MethodDescriptor.<com.example.agentgrpc.protocol.collector.AgentStatusReq, com.example.agentgrpc.protocol.collector.AgentStatusRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AgentStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.collector.AgentStatusReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.collector.AgentStatusRes.getDefaultInstance()))
              .setSchemaDescriptor(new CollectorMethodDescriptorSupplier("AgentStatus"))
              .build();
        }
      }
    }
    return getAgentStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.collector.TaskStatusReq,
      com.example.agentgrpc.protocol.collector.TaskStatusRes> getTaskStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TaskStatus",
      requestType = com.example.agentgrpc.protocol.collector.TaskStatusReq.class,
      responseType = com.example.agentgrpc.protocol.collector.TaskStatusRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.collector.TaskStatusReq,
      com.example.agentgrpc.protocol.collector.TaskStatusRes> getTaskStatusMethod() {
    io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.collector.TaskStatusReq, com.example.agentgrpc.protocol.collector.TaskStatusRes> getTaskStatusMethod;
    if ((getTaskStatusMethod = CollectorGrpc.getTaskStatusMethod) == null) {
      synchronized (CollectorGrpc.class) {
        if ((getTaskStatusMethod = CollectorGrpc.getTaskStatusMethod) == null) {
          CollectorGrpc.getTaskStatusMethod = getTaskStatusMethod =
              io.grpc.MethodDescriptor.<com.example.agentgrpc.protocol.collector.TaskStatusReq, com.example.agentgrpc.protocol.collector.TaskStatusRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TaskStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.collector.TaskStatusReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.collector.TaskStatusRes.getDefaultInstance()))
              .setSchemaDescriptor(new CollectorMethodDescriptorSupplier("TaskStatus"))
              .build();
        }
      }
    }
    return getTaskStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CollectorStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CollectorStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CollectorStub>() {
        @java.lang.Override
        public CollectorStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CollectorStub(channel, callOptions);
        }
      };
    return CollectorStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CollectorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CollectorBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CollectorBlockingStub>() {
        @java.lang.Override
        public CollectorBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CollectorBlockingStub(channel, callOptions);
        }
      };
    return CollectorBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CollectorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CollectorFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CollectorFutureStub>() {
        @java.lang.Override
        public CollectorFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CollectorFutureStub(channel, callOptions);
        }
      };
    return CollectorFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *中心节点作为server
   * </pre>
   */
  public static abstract class CollectorImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *执行状态更新，每个agent主动上报 -- 此功能可以先不实现
     * </pre>
     */
    public void agentStatus(com.example.agentgrpc.protocol.collector.AgentStatusReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.collector.AgentStatusRes> responseObserver) {
      asyncUnimplementedUnaryCall(getAgentStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     *任务状态更新,code返回执行中的任务，完成后需要上报
     * </pre>
     */
    public void taskStatus(com.example.agentgrpc.protocol.collector.TaskStatusReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.collector.TaskStatusRes> responseObserver) {
      asyncUnimplementedUnaryCall(getTaskStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAgentStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.agentgrpc.protocol.collector.AgentStatusReq,
                com.example.agentgrpc.protocol.collector.AgentStatusRes>(
                  this, METHODID_AGENT_STATUS)))
          .addMethod(
            getTaskStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.agentgrpc.protocol.collector.TaskStatusReq,
                com.example.agentgrpc.protocol.collector.TaskStatusRes>(
                  this, METHODID_TASK_STATUS)))
          .build();
    }
  }

  /**
   * <pre>
   *中心节点作为server
   * </pre>
   */
  public static final class CollectorStub extends io.grpc.stub.AbstractAsyncStub<CollectorStub> {
    private CollectorStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CollectorStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CollectorStub(channel, callOptions);
    }

    /**
     * <pre>
     *执行状态更新，每个agent主动上报 -- 此功能可以先不实现
     * </pre>
     */
    public void agentStatus(com.example.agentgrpc.protocol.collector.AgentStatusReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.collector.AgentStatusRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAgentStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *任务状态更新,code返回执行中的任务，完成后需要上报
     * </pre>
     */
    public void taskStatus(com.example.agentgrpc.protocol.collector.TaskStatusReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.collector.TaskStatusRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTaskStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *中心节点作为server
   * </pre>
   */
  public static final class CollectorBlockingStub extends io.grpc.stub.AbstractBlockingStub<CollectorBlockingStub> {
    private CollectorBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CollectorBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CollectorBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *执行状态更新，每个agent主动上报 -- 此功能可以先不实现
     * </pre>
     */
    public com.example.agentgrpc.protocol.collector.AgentStatusRes agentStatus(com.example.agentgrpc.protocol.collector.AgentStatusReq request) {
      return blockingUnaryCall(
          getChannel(), getAgentStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *任务状态更新,code返回执行中的任务，完成后需要上报
     * </pre>
     */
    public com.example.agentgrpc.protocol.collector.TaskStatusRes taskStatus(com.example.agentgrpc.protocol.collector.TaskStatusReq request) {
      return blockingUnaryCall(
          getChannel(), getTaskStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *中心节点作为server
   * </pre>
   */
  public static final class CollectorFutureStub extends io.grpc.stub.AbstractFutureStub<CollectorFutureStub> {
    private CollectorFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CollectorFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CollectorFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *执行状态更新，每个agent主动上报 -- 此功能可以先不实现
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.agentgrpc.protocol.collector.AgentStatusRes> agentStatus(
        com.example.agentgrpc.protocol.collector.AgentStatusReq request) {
      return futureUnaryCall(
          getChannel().newCall(getAgentStatusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *任务状态更新,code返回执行中的任务，完成后需要上报
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.agentgrpc.protocol.collector.TaskStatusRes> taskStatus(
        com.example.agentgrpc.protocol.collector.TaskStatusReq request) {
      return futureUnaryCall(
          getChannel().newCall(getTaskStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AGENT_STATUS = 0;
  private static final int METHODID_TASK_STATUS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CollectorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CollectorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AGENT_STATUS:
          serviceImpl.agentStatus((com.example.agentgrpc.protocol.collector.AgentStatusReq) request,
              (io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.collector.AgentStatusRes>) responseObserver);
          break;
        case METHODID_TASK_STATUS:
          serviceImpl.taskStatus((com.example.agentgrpc.protocol.collector.TaskStatusReq) request,
              (io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.collector.TaskStatusRes>) responseObserver);
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

  private static abstract class CollectorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CollectorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.agentgrpc.protocol.collector.CollectorOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Collector");
    }
  }

  private static final class CollectorFileDescriptorSupplier
      extends CollectorBaseDescriptorSupplier {
    CollectorFileDescriptorSupplier() {}
  }

  private static final class CollectorMethodDescriptorSupplier
      extends CollectorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CollectorMethodDescriptorSupplier(String methodName) {
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
      synchronized (CollectorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CollectorFileDescriptorSupplier())
              .addMethod(getAgentStatusMethod())
              .addMethod(getTaskStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
