package com.example.agentgrpc.protocol.agent;

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
 *agent管理
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.26.0)",
    comments = "Source: agent.proto")
public final class AgentGrpc {

  private AgentGrpc() {}

  public static final String SERVICE_NAME = "agent.Agent";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.agent.UpdateAgentReq,
      com.example.agentgrpc.protocol.agent.UpdateAgentRes> getUpdateAgentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAgent",
      requestType = com.example.agentgrpc.protocol.agent.UpdateAgentReq.class,
      responseType = com.example.agentgrpc.protocol.agent.UpdateAgentRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.agent.UpdateAgentReq,
      com.example.agentgrpc.protocol.agent.UpdateAgentRes> getUpdateAgentMethod() {
    io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.agent.UpdateAgentReq, com.example.agentgrpc.protocol.agent.UpdateAgentRes> getUpdateAgentMethod;
    if ((getUpdateAgentMethod = AgentGrpc.getUpdateAgentMethod) == null) {
      synchronized (AgentGrpc.class) {
        if ((getUpdateAgentMethod = AgentGrpc.getUpdateAgentMethod) == null) {
          AgentGrpc.getUpdateAgentMethod = getUpdateAgentMethod =
              io.grpc.MethodDescriptor.<com.example.agentgrpc.protocol.agent.UpdateAgentReq, com.example.agentgrpc.protocol.agent.UpdateAgentRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAgent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.agent.UpdateAgentReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.agent.UpdateAgentRes.getDefaultInstance()))
              .setSchemaDescriptor(new AgentMethodDescriptorSupplier("UpdateAgent"))
              .build();
        }
      }
    }
    return getUpdateAgentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AgentStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AgentStub>() {
        @java.lang.Override
        public AgentStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AgentStub(channel, callOptions);
        }
      };
    return AgentStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AgentBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AgentBlockingStub>() {
        @java.lang.Override
        public AgentBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AgentBlockingStub(channel, callOptions);
        }
      };
    return AgentBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AgentFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AgentFutureStub>() {
        @java.lang.Override
        public AgentFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AgentFutureStub(channel, callOptions);
        }
      };
    return AgentFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *agent管理
   * </pre>
   */
  public static abstract class AgentImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *更新
     * </pre>
     */
    public void updateAgent(com.example.agentgrpc.protocol.agent.UpdateAgentReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.agent.UpdateAgentRes> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateAgentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUpdateAgentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.agentgrpc.protocol.agent.UpdateAgentReq,
                com.example.agentgrpc.protocol.agent.UpdateAgentRes>(
                  this, METHODID_UPDATE_AGENT)))
          .build();
    }
  }

  /**
   * <pre>
   *agent管理
   * </pre>
   */
  public static final class AgentStub extends io.grpc.stub.AbstractAsyncStub<AgentStub> {
    private AgentStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentStub(channel, callOptions);
    }

    /**
     * <pre>
     *更新
     * </pre>
     */
    public void updateAgent(com.example.agentgrpc.protocol.agent.UpdateAgentReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.agent.UpdateAgentRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateAgentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *agent管理
   * </pre>
   */
  public static final class AgentBlockingStub extends io.grpc.stub.AbstractBlockingStub<AgentBlockingStub> {
    private AgentBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *更新
     * </pre>
     */
    public com.example.agentgrpc.protocol.agent.UpdateAgentRes updateAgent(com.example.agentgrpc.protocol.agent.UpdateAgentReq request) {
      return blockingUnaryCall(
          getChannel(), getUpdateAgentMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *agent管理
   * </pre>
   */
  public static final class AgentFutureStub extends io.grpc.stub.AbstractFutureStub<AgentFutureStub> {
    private AgentFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *更新
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.agentgrpc.protocol.agent.UpdateAgentRes> updateAgent(
        com.example.agentgrpc.protocol.agent.UpdateAgentReq request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateAgentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPDATE_AGENT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AgentImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AgentImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPDATE_AGENT:
          serviceImpl.updateAgent((com.example.agentgrpc.protocol.agent.UpdateAgentReq) request,
              (io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.agent.UpdateAgentRes>) responseObserver);
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

  private static abstract class AgentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AgentBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.agentgrpc.protocol.agent.AgentOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Agent");
    }
  }

  private static final class AgentFileDescriptorSupplier
      extends AgentBaseDescriptorSupplier {
    AgentFileDescriptorSupplier() {}
  }

  private static final class AgentMethodDescriptorSupplier
      extends AgentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AgentMethodDescriptorSupplier(String methodName) {
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
      synchronized (AgentGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AgentFileDescriptorSupplier())
              .addMethod(getUpdateAgentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
