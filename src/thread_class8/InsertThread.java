package thread_class8;

import javax.jws.Oneway;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class InsertThread implements Runnable {
    private volatile LinkedList<String> queue;
    private Logger logger = null;       //没有日志类，将就

    public InsertThread(LinkedList queue){
        this.queue = queue;
    }

    @Override
    public void run() {
            if (!queue.isEmpty()) {     //链表不为空开始插入数据
                String info = queue.pop();
                int len = info.length();
                if(len < 56){
                    logger.info("udp接收到数据长度不符合56位格式"+info);
                    return;
                }
                // 第1、2位为出开始标志
                String start = info.substring(0, 2);
                if(!"02".equals(start)){
                    logger.info("udp接收到数据开头不符合02格式"+info);
                    return;
                }
                // 出入库标志
                // 01入库
                if(len ==56){
                    //结尾标识
                    String end = info.substring(52,56);
                    if(!"0D0A".equals(end)){
                        logger.info("udp接收到数据结尾不符合0D0A格式"+info);
                        return;
                    }
                    // 第3、4位为货区标志
                    String container = info.substring(2,4);
                    // 第5、6位为出入库标志
                    String ioType = info.substring(4,6);
                    // 40位二维码
                    String barCode = info.substring(6,46);
                    // 6位货位码
                    String locId = info.substring(46,52);
                    //应答成功返回
//                    String result = UdpUtil.sendSuccUdpInfo(ioType);
//                    udpRecordService.saveERPUdpIno(result);
                    switch (ioType){
                        case "01":
                            logger.info("开始记录入库二维码信息");
//                            billDetailCodesService.saveUdpData(barCode,container,locId);
                            return;
                        case "03":
                            return;
                        default:
                    }
            /*if(!ioType.equals("01")&&!ioType.equals("03")&&!ioType.equals("05")){
                logger.info("udp接收到数据不是入库数据也不是退料数据更不是超期复验合格入库数据");
                return;
            }*/

                }else if(len ==63){
                    //结尾标识
                    String end = info.substring(59,63);
                    if(!"0D0A".equals(end)){
                        logger.info("udp接收到数据结尾不符合0D0A格式"+info);
                        return;
                    }
                    String ioType = info.substring(2,4);
                    String billNum = info.substring(4,19);
                    String barCode = info.substring(19,59);
                    // 02出库
//                    String result = UdpUtil.sendSuccUdpInfo(ioType);
//                    udpRecordService.saveERPUdpIno(result);
                    logger.info("开始记录数据出库信息");
//                    billDetailCodesService.saveUdpData(barCode,billNum);
                }else if(len == 71){
                    logger.info("开始处理退料返回udp信息");
                    // 第3、4位为货区标志
                    String container = info.substring(2,4);
                    // 第5、6位为出入库标志
                    String ioType = info.substring(4,6);
                    String billNum = info.substring(6,21);
                    String barCode = info.substring(21,61);
                    String locId = info.substring(61,67);
//                    String result = UdpUtil.sendSuccUdpInfo(ioType);
//                    udpRecordService.saveERPUdpIno(result);
                    logger.info("开始记录数据退料信息");
//                    billDetailCodesService.saveOutTreasuryUdpData(barCode,billNum,container,locId);
                }else{
                    logger.info("不符合的udp日志信息");
                }
            }

            try {   //如果链表为空，则一直阻塞线程
                queue.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
    }
}
