package test.reflect;

/**
 * 日期 : 3/20/25
 * 创建 : Xin.Li
 * 描述 : 发卡箱各功能api
 */
public class F3CardManager {
    private static final int STATUS_SUCCESS = 200;
    private static final int STATUS_FAILED = -1;
    /**
     * dev/ttyUSB： 发卡箱串口号usb名称
     * 9600： 发卡箱波特率
     */
    private static final String F3_DEVICE_PATH = "dev/ttyUSB";
    private static final int F3_DEVICE_BAUD_RATES = 9600;


    /**
     * 设备是否已经链接
     */
    public static boolean isConnected() {
        return false;
    }

}
