package com.example.agentgrpc.protocol.stress;

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
    comments = "Source: stress.proto")
public final class StressGrpc {

  private StressGrpc() {}

  public static final String SERVICE_NAME = "agent.Stress";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.stress.StartStressReq,
      com.example.agentgrpc.protocol.stress.StartStressRes> getStartStressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartStress",
      requestType = com.example.agentgrpc.protocol.stress.StartStressReq.class,
      responseType = com.example.agentgrpc.protocol.stress.StartStressRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.stress.StartStressReq,
      com.example.agentgrpc.protocol.stress.StartStressRes> getStartStressMethod() {
    io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.stress.StartStressReq, com.example.agentgrpc.protocol.stress.StartStressRes> getStartStressMethod;
    if ((getStartStressMethod = StressGrpc.getStartStressMethod) == null) {
      synchronized (StressGrpc.class) {
        if ((getStartStressMethod = StressGrpc.getStartStressMethod) == null) {
          StressGrpc.getStartStressMethod = getStartStressMethod =
              io.grpc.MethodDescriptor.<com.example.agentgrpc.protocol.stress.StartStressReq, com.example.agentgrpc.protocol.stress.StartStressRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartStress"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.stress.StartStressReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.stress.StartStressRes.getDefaultInstance()))
              .setSchemaDescriptor(new StressMethodDescriptorSupplier("StartStress"))
              .build();
        }
      }
    }
    return getStartStressMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.stress.StopStressReq,
      com.example.agentgrpc.protocol.stress.StopStressRes> getStopStressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopStress",
      requestType = com.example.agentgrpc.protocol.stress.StopStressReq.class,
      responseType = com.example.agentgrpc.protocol.stress.StopStressRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.stress.StopStressReq,
      com.example.agentgrpc.protocol.stress.StopStressRes> getStopStressMethod() {
    io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.stress.StopStressReq, com.example.agentgrpc.protocol.stress.StopStressRes> getStopStressMethod;
    if ((getStopStressMethod = StressGrpc.getStopStressMethod) == null) {
      synchronized (StressGrpc.class) {
        if ((getStopStressMethod = StressGrpc.getStopStressMethod) == null) {
          StressGrpc.getStopStressMethod = getStopStressMethod =
              io.grpc.MethodDescriptor.<com.example.agentgrpc.protocol.stress.StopStressReq, com.example.agentgrpc.protocol.stress.StopStressRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopStress"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.stress.StopStressReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.stress.StopStressRes.getDefaultInstance()))
              .setSchemaDescriptor(new StressMethodDescriptorSupplier("StopStress"))
              .build();
        }
      }
    }
    return getStopStressMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.stress.JsonResultReq,
      com.example.agentgrpc.protocol.stress.JsonResultRes> getJsonResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JsonResult",
      requestType = com.example.agentgrpc.protocol.stress.JsonResultReq.class,
      responseType = com.example.agentgrpc.protocol.stress.JsonResultRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.stress.JsonResultReq,
      com.example.agentgrpc.protocol.stress.JsonResultRes> getJsonResultMethod() {
    io.grpc.MethodDescriptor<com.example.agentgrpc.protocol.stress.JsonResultReq, com.example.agentgrpc.protocol.stress.JsonResultRes> getJsonResultMethod;
    if ((getJsonResultMethod = StressGrpc.getJsonResultMethod) == null) {
      synchronized (StressGrpc.class) {
        if ((getJsonResultMethod = StressGrpc.getJsonResultMethod) == null) {
          StressGrpc.getJsonResultMethod = getJsonResultMethod =
              io.grpc.MethodDescriptor.<com.example.agentgrpc.protocol.stress.JsonResultReq, com.example.agentgrpc.protocol.stress.JsonResultRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JsonResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.stress.JsonResultReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.agentgrpc.protocol.stress.JsonResultRes.getDefaultInstance()))
              .setSchemaDescriptor(new StressMethodDescriptorSupplier("JsonResult"))
              .build();
        }
      }
    }
    return getJsonResultMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StressStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StressStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StressStub>() {
        @java.lang.Override
        public StressStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StressStub(channel, callOptions);
        }
      };
    return StressStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StressBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StressBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StressBlockingStub>() {
        @java.lang.Override
        public StressBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StressBlockingStub(channel, callOptions);
        }
      };
    return StressBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StressFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StressFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StressFutureStub>() {
        @java.lang.Override
        public StressFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StressFutureStub(channel, callOptions);
        }
      };
    return StressFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *agent作为server
   * </pre>
   */
  public static abstract class StressImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *开始压测
     * </pre>
     */
    public void startStress(com.example.agentgrpc.protocol.stress.StartStressReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.stress.StartStressRes> responseObserver) {
      asyncUnimplementedUnaryCall(getStartStressMethod(), responseObserver);
    }

    /**
     * <pre>
     *停止压测
     * </pre>
     */
    public void stopStress(com.example.agentgrpc.protocol.stress.StopStressReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.stress.StopStressRes> responseObserver) {
      asyncUnimplementedUnaryCall(getStopStressMethod(), responseObserver);
    }

    /**
     * <pre>
     *获取结果文件。上传完成后要归档已获取的文件。将本次任务之前的结果文件全部解析
     * </pre>
     */
    public void jsonResult(com.example.agentgrpc.protocol.stress.JsonResultReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.stress.JsonResultRes> responseObserver) {
      asyncUnimplementedUnaryCall(getJsonResultMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStartStressMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.agentgrpc.protocol.stress.StartStressReq,
                com.example.agentgrpc.protocol.stress.StartStressRes>(
                  this, METHODID_START_STRESS)))
          .addMethod(
            getStopStressMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.agentgrpc.protocol.stress.StopStressReq,
                com.example.agentgrpc.protocol.stress.StopStressRes>(
                  this, METHODID_STOP_STRESS)))
          .addMethod(
            getJsonResultMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.example.agentgrpc.protocol.stress.JsonResultReq,
                com.example.agentgrpc.protocol.stress.JsonResultRes>(
                  this, METHODID_JSON_RESULT)))
          .build();
    }
  }

  /**
   * <pre>
   *agent作为server
   * </pre>
   */
  public static final class StressStub extends io.grpc.stub.AbstractAsyncStub<StressStub> {
    private StressStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StressStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StressStub(channel, callOptions);
    }

    /**
     * <pre>
     *开始压测
     * </pre>
     */
    public void startStress(com.example.agentgrpc.protocol.stress.StartStressReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.stress.StartStressRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStartStressMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *停止压测
     * </pre>
     */
    public void stopStress(com.example.agentgrpc.protocol.stress.StopStressReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.stress.StopStressRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStopStressMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *获取结果文件。上传完成后要归档已获取的文件。将本次任务之前的结果文件全部解析
     * </pre>
     */
    public void jsonResult(com.example.agentgrpc.protocol.stress.JsonResultReq request,
        io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.stress.JsonResultRes> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getJsonResultMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *agent作为server
   * </pre>
   */
  public static final class StressBlockingStub extends io.grpc.stub.AbstractBlockingStub<StressBlockingStub> {
    private StressBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StressBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StressBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *开始压测
     * </pre>
     */
    public com.example.agentgrpc.protocol.stress.StartStressRes startStress(com.example.agentgrpc.protocol.stress.StartStressReq request) {
      return blockingUnaryCall(
          getChannel(), getStartStressMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *停止压测
     * </pre>
     */
    public com.example.agentgrpc.protocol.stress.StopStressRes stopStress(com.example.agentgrpc.protocol.stress.StopStressReq request) {
      return blockingUnaryCall(
          getChannel(), getStopStressMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *获取结果文件。上传完成后要归档已获取的文件。将本次任务之前的结果文件全部解析
     * </pre>
     */
    public java.util.Iterator<com.example.agentgrpc.protocol.stress.JsonResultRes> jsonResult(
        com.example.agentgrpc.protocol.stress.JsonResultReq request) {
      return blockingServerStreamingCall(
          getChannel(), getJsonResultMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *agent作为server
   * </pre>
   */
  public static final class StressFutureStub extends io.grpc.stub.AbstractFutureStub<StressFutureStub> {
    private StressFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StressFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StressFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *开始压测
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.agentgrpc.protocol.stress.StartStressRes> startStress(
        com.example.agentgrpc.protocol.stress.StartStressReq request) {
      return futureUnaryCall(
          getChannel().newCall(getStartStressMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *停止压测
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.agentgrpc.protocol.stress.StopStressRes> stopStress(
        com.example.agentgrpc.protocol.stress.StopStressReq request) {
      return futureUnaryCall(
          getChannel().newCall(getStopStressMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_START_STRESS = 0;
  private static final int METHODID_STOP_STRESS = 1;
  private static final int METHODID_JSON_RESULT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StressImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StressImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_START_STRESS:
          serviceImpl.startStress((com.example.agentgrpc.protocol.stress.StartStressReq) request,
              (io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.stress.StartStressRes>) responseObserver);
          break;
        case METHODID_STOP_STRESS:
          serviceImpl.stopStress((com.example.agentgrpc.protocol.stress.StopStressReq) request,
              (io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.stress.StopStressRes>) responseObserver);
          break;
        case METHODID_JSON_RESULT:
          serviceImpl.jsonResult((com.example.agentgrpc.protocol.stress.JsonResultReq) request,
              (io.grpc.stub.StreamObserver<com.example.agentgrpc.protocol.stress.JsonResultRes>) responseObserver);
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

  private static abstract class StressBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StressBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.agentgrpc.protocol.stress.StressOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Stress");
    }
  }

  private static final class StressFileDescriptorSupplier
      extends StressBaseDescriptorSupplier {
    StressFileDescriptorSupplier() {}
  }

  private static final class StressMethodDescriptorSupplier
      extends StressBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StressMethodDescriptorSupplier(String methodName) {
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
      synchronized (StressGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StressFileDescriptorSupplier())
              .addMethod(getStartStressMethod())
              .addMethod(getStopStressMethod())
              .addMethod(getJsonResultMethod())
              .build();
        }
      }
    }
    return result;
  }
}
