//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

//io/quarkus/runner/ApplicationImpl.class decompiled code
// for the sake of understanding quarkus "build time boot" 
//The bytecode can be found in targt/*-runner.jar
//
package io.quarkus.runner;

import io.quarkus.bootstrap.logging.InitialConfigurator;
import io.quarkus.bootstrap.runner.Timing;
import io.quarkus.deployment.steps.BootstrapConfigSetup;
import io.quarkus.deployment.steps.RuntimeConfigSetup;
import io.quarkus.deployment.steps.ArcProcessor.generateResources1649676420;
import io.quarkus.deployment.steps.ArcProcessor.setupExecutor-1831044820;
import io.quarkus.deployment.steps.BannerProcessor.recordBanner-1279842229;
import io.quarkus.deployment.steps.BlockingOperationControlBuildStep.blockingOP558072755;
import io.quarkus.deployment.steps.CommandLineArgumentsProcessor.commandLineArgs71756378;
import io.quarkus.deployment.steps.ConfigBuildStep.validateConfigProperties1249763973;
import io.quarkus.deployment.steps.ConfigGenerationBuildStep.checkForBuildTimeConfigChange-1100481704;
import io.quarkus.deployment.steps.HttpSecurityProcessor.initBasicAuth583370107;
import io.quarkus.deployment.steps.LifecycleEventsBuildStep.startupEvent-858218658;
import io.quarkus.deployment.steps.LoggingResourceProcessor.setupLoggingRuntimeInit2028700189;
import io.quarkus.deployment.steps.LoggingResourceProcessor.setupLoggingStaticInit-1235809433;
import io.quarkus.deployment.steps.NativeImageConfigBuildStep.build163995889;
import io.quarkus.deployment.steps.NettyProcessor.eagerlyInitClass-1832577802;
import io.quarkus.deployment.steps.ResteasyCommonProcessor.setupResteasyInjection-1799175235;
import io.quarkus.deployment.steps.ResteasyStandaloneBuildStep.boot-614950547;
import io.quarkus.deployment.steps.ResteasyStandaloneBuildStep.staticInit-210558872;
import io.quarkus.deployment.steps.ShutdownListenerBuildStep.setupShutdown24485890;
import io.quarkus.deployment.steps.StaticResourcesProcessor.runtimeInit1493424519;
import io.quarkus.deployment.steps.StaticResourcesProcessor.staticInit-1777814589;
import io.quarkus.deployment.steps.SyntheticBeansProcessor.initRuntime-975230615;
import io.quarkus.deployment.steps.SyntheticBeansProcessor.initStatic1190120725;
import io.quarkus.deployment.steps.ThreadPoolSetup.createExecutor-168269452;
import io.quarkus.deployment.steps.VertxCoreProcessor.build-956362597;
import io.quarkus.deployment.steps.VertxCoreProcessor.eventLoopCount1012482323;
import io.quarkus.deployment.steps.VertxCoreProcessor.ioThreadDetector-1463825589;
import io.quarkus.deployment.steps.VertxHttpProcessor.bodyHandler1204734842;
import io.quarkus.deployment.steps.VertxHttpProcessor.cors-1956812358;
import io.quarkus.deployment.steps.VertxHttpProcessor.finalizeRouter749274288;
import io.quarkus.deployment.steps.VertxHttpProcessor.initializeRouter304369008;
import io.quarkus.deployment.steps.VertxHttpProcessor.openSocket-2064782366;
import io.quarkus.dev.appstate.ApplicationStateNotification;
import io.quarkus.runtime.Application;
import io.quarkus.runtime.LaunchMode;
import io.quarkus.runtime.NativeImageRuntimePropertiesRecorder;
import io.quarkus.runtime.StartupContext;
import io.quarkus.runtime.StartupTask;
import io.quarkus.runtime.configuration.ProfileManager;
import io.quarkus.runtime.generated.Config;
import io.quarkus.runtime.util.StepTiming;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import org.graalvm.nativeimage.ImageInfo;
import org.jboss.logging.Logger;
import org.jboss.logmanager.handlers.DelayedHandler;

// $FF: synthetic class
public class ApplicationImpl extends Application {
    static Logger LOG;
    public static StartupContext STARTUP_CONTEXT;

    public ApplicationImpl() {
    }

    static {
        System.setProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager");
        System.setProperty("io.netty.allocator.maxOrder", "1");
        System.setProperty("io.netty.machineId", "84:e9:7c:3d:c0:46:1a:86");
        ProfileManager.setLaunchMode(LaunchMode.NORMAL);
        StepTiming.configureEnabled();
        Timing.staticInitStarted();
        Config.ensureInitialized();
        LOG = Logger.getLogger("io.quarkus.application");
        StartupContext var0 = new StartupContext();
        STARTUP_CONTEXT = var0;

        try {
            StepTiming.configureStart();
            ((StartupTask)(new commandLineArgs71756378())).deploy(var0);
            StepTiming.printStepTime(var0);
            ((StartupTask)(new ioThreadDetector-1463825589())).deploy(var0);
            StepTiming.printStepTime(var0);
            ((StartupTask)(new setupLoggingStaticInit-1235809433())).deploy(var0);
            StepTiming.printStepTime(var0);
            ((StartupTask)(new blockingOP558072755())).deploy(var0);
            StepTiming.printStepTime(var0);
            ((StartupTask)(new build163995889())).deploy(var0);
            StepTiming.printStepTime(var0);
            ((StartupTask)(new staticInit-1777814589())).deploy(var0);
            StepTiming.printStepTime(var0);
            ((StartupTask)(new initStatic1190120725())).deploy(var0);
            StepTiming.printStepTime(var0);
            ((StartupTask)(new generateResources1649676420())).deploy(var0);
            StepTiming.printStepTime(var0);
            ((StartupTask)(new setupResteasyInjection-1799175235())).deploy(var0);
            StepTiming.printStepTime(var0);
            ((StartupTask)(new staticInit-210558872())).deploy(var0);
            StepTiming.printStepTime(var0);
        } catch (Throwable var2) {
            ApplicationStateNotification.notifyStartupFailed(var2);
            var0.close();
            throw (Throwable)(new RuntimeException("Failed to start quarkus", var2));
        }
    }

    protected final void doStart(String[] var1) {
        System.setProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager");
        System.setProperty("io.netty.allocator.maxOrder", "1");
        System.setProperty("io.netty.machineId", "84:e9:7c:3d:c0:46:1a:86");
        NativeImageRuntimePropertiesRecorder.doRuntime();
        if (ImageInfo.inImageRuntimeCode()) {
            if (System.getProperty("javax.net.ssl.trustStore") != null) {
                LOG.warn("Setting the 'javax.net.ssl.trustStore' system property will not have any effect at runtime. Make sure to set this property at build time (for example by setting 'quarkus.native.additional-build-args=-J-Djavax.net.ssl.trustStore=someValue').");
            }

            if (System.getProperty("javax.net.ssl.trustStoreType") != null) {
                LOG.warn("Setting the 'javax.net.ssl.trustStoreType' system property will not have any effect at runtime. Make sure to set this property at build time (for example by setting 'quarkus.native.additional-build-args=-J-Djavax.net.ssl.trustStoreType=someValue').");
            }

            if (System.getProperty("javax.net.ssl.trustStoreProvider") != null) {
                LOG.warn("Setting the 'javax.net.ssl.trustStoreProvider' system property will not have any effect at runtime. Make sure to set this property at build time (for example by setting 'quarkus.native.additional-build-args=-J-Djavax.net.ssl.trustStoreProvider=someValue').");
            }

            if (System.getProperty("javax.net.ssl.trustStorePassword") != null) {
                LOG.warn("Setting the 'javax.net.ssl.trustStorePassword' system property will not have any effect at runtime. Make sure to set this property at build time (for example by setting 'quarkus.native.additional-build-args=-J-Djavax.net.ssl.trustStorePassword=someValue').");
            }
        }

        Timing.mainStarted();
        StartupContext var2 = STARTUP_CONTEXT;
        var2.setCommandLineArguments(var1);
        StepTiming.configureEnabled();
        String var3 = ProfileManager.getActiveProfile();

        try {
            StepTiming.configureStart();
            ((StartupTask)(new BootstrapConfigSetup())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new eagerlyInitClass-1832577802())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new RuntimeConfigSetup())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new createExecutor-168269452())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new eventLoopCount1012482323())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new setupExecutor-1831044820())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new build-956362597())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new recordBanner-1279842229())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new cors-1956812358())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new initBasicAuth583370107())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new bodyHandler1204734842())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new setupLoggingRuntimeInit2028700189())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new checkForBuildTimeConfigChange-1100481704())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new initRuntime-975230615())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new runtimeInit1493424519())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new validateConfigProperties1249763973())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new boot-614950547())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new initializeRouter304369008())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new finalizeRouter749274288())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new startupEvent-858218658())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new openSocket-2064782366())).deploy(var2);
            StepTiming.printStepTime(var2);
            ((StartupTask)(new setupShutdown24485890())).deploy(var2);
            StepTiming.printStepTime(var2);
            Timing.printStartupTime("quarkus-getting-started", "1.0.0-SNAPSHOT", "1.8.3.Final", "cdi, config-yaml, resteasy", var3, (boolean)0);
        } catch (Throwable var8) {
            LOG.errorv(var8, "Failed to start application (with profile {0})", var3);
            DelayedHandler var7 = InitialConfigurator.DELAYED_HANDLER;
            if (!var7.isActivated()) {
                Handler[] var5 = new Handler[1];
                ConsoleHandler var6 = new ConsoleHandler();
                var5[0] = (Handler)var6;
                var7.setHandlers(var5);
            }

            var2.close();
            throw (Throwable)(new RuntimeException("Failed to start quarkus", var8));
        }
    }

    protected final void doStop() {
        STARTUP_CONTEXT.close();
    }

    public String getName() {
        return "quarkus-getting-started";
    }
}
