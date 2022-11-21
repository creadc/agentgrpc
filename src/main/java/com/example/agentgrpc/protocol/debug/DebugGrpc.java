package com.example.agentgrpc.protocol.debug;

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
 *调试
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.26.0)",
    comments = "Source: debug.proto")
public final class DebugGrpc {

  private DebugGrpc() {}

  public static final String SERVICE_NAME = "agent.Debug";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.debug.ContextReq,
      com.example.agentgrpc.protocol.debug.ContextRes> getGetServletContextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServletContext",
      requestType = com.example.agentgrpc.protocol.debug.ContextReq.class,
      responseType = com.example.agentgrpc.protocol.debug.ContextRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.debug.ContextReq,
      com.example.agentgrpc.protocol.debug.ContextRes> getGetServletContextMethod() {
    io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.debug.ContextReq, com.example.agentgrpc.protocol.debug.ContextRes> getGetServletContextMethod;
    if ((getGetServletContextMethod = DebugGrpc.getGetServletContextMethod) == null) {
      synchronized (DebugGrpc.class) {
        if ((getGetServletContextMethod = DebugGrpc.getGetServletContextMethod) == null) {
          DebugGrpc.getGetServletContextMethod = getGetServletContextMethod =
              io.grpc.MethodDescriptor.<com.example.agentgrpc.protocol.debug.ContextReq, com.example.agentgrpc.protocol.debug.ContextRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServletContext"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.debug.ContextReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.debug.ContextRes.getDefaultInstance()))
              .setSchemaDescriptor(new DebugMethodDescriptorSupplier("GetServletContext"))
              .build();
        }
      }
    }
    return getGetServletContextMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DebugStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DebugStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DebugStub>() {
        @java.lang.Override
        public DebugStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DebugStub(channel, callOptions);
        }
      };
    return DebugStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DebugBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DebugBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DebugBlockingStub>() {
        @java.lang.Override
        public DebugBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DebugBlockingStub(channel, callOptions);
        }
      };
    return DebugBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DebugFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DebugFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DebugFutureStub>() {
        @java.lang.Override
        public DebugFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DebugFutureStub(channel, callOptions);
        }
      };
    return DebugFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *调试
   * </pre>
   */
  public static abstract class DebugImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *获取上下文
     * </pre>
     */
    public void getServletContext(com.example.agentgrpc.protocol.debug.ContextReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.debug.ContextRes> responseObserver) {
      asyncUnimplementedUnaryCall(getGetServletContextMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetServletContextMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.agentgrpc.protocol.debug.ContextReq,
                com.example.agentgrpc.protocol.debug.ContextRes>(
                  this, METHODID_GET_SERVLET_CONTEXT)))
          .build();
    }
  }

  /**
   * <pre>
   *调试
   * </pre>
   */
  public static final class DebugStub extends io.grpc.stub.AbstractAsyncStub<DebugStub> {
    private DebugStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DebugStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DebugStub(channel, callOptions);
    }

    /**
     * <pre>
     *获取上下文
     * </pre>
     */
    public void getServletContext(com.example.agentgrpc.protocol.debug.ContextReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.debug.ContextRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetServletContextMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *调试
   * </pre>
   */
  public static final class DebugBlockingStub extends io.grpc.stub.AbstractBlockingStub<DebugBlockingStub> {
    private DebugBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DebugBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DebugBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *获取上下文
     * </pre>
     */
    public com.example.agentgrpc.protocol.debug.ContextRes getServletContext(com.example.agentgrpc.protocol.debug.ContextReq request) {
      return blockingUnaryCall(
          getChannel(), getGetServletContextMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *调试
   * </pre>
   */
  public static final class DebugFutureStub extends io.grpc.stub.AbstractFutureStub<DebugFutureStub> {
    private DebugFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DebugFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DebugFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *获取上下文
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.agentgrpc.protocol.debug.ContextRes> getServletContext(
        com.example.agentgrpc.protocol.debug.ContextReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetServletContextMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SERVLET_CONTEXT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DebugImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DebugImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SERVLET_CONTEXT:
          serviceImpl.getServletContext((com.example.agentgrpc.protocol.debug.ContextReq) request,
              (io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.debug.ContextRes>) responseObserver);
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

  private static abstract class DebugBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DebugBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.agentgrpc.protocol.debug.DebugOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Debug");
    }
  }

  private static final class DebugFileDescriptorSupplier
      extends DebugBaseDescriptorSupplier {
    DebugFileDescriptorSupplier() {}
  }

  private static final class DebugMethodDescriptorSupplier
      extends DebugBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DebugMethodDescriptorSupplier(String methodName) {
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
      synchronized (DebugGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DebugFileDescriptorSupplier())
              .addMethod(getGetServletContextMethod())
              .build();
        }
      }
    }
    return result;
  }
}
