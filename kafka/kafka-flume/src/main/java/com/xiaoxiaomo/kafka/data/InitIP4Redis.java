package com.xiaoxiaomo.kafka.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.xiaoxiaomo.kafka.utils.RedisUtils;
import redis.clients.jedis.Jedis;

public class InitIP4Redis {

	
	public static void main(String[] args) throws Exception {

        Jedis jedis = RedisUtils.getJedis();

//		jedis.set("ip:61.172.249.96","北京市	海淀区");
//		jedis.set("ip:211.155.234.99","河北省	邢台区");
//		jedis.set("ip:218.75.100.114","北京市	昌平区");
//		jedis.set("ip:211.167.248.22","上海市	浦东新区");
//		jedis.set("ip:60.12.227.208","江西省	赣州市");
//		jedis.set("ip:221.8.9.6 80","海南省	海口市");
//		jedis.set("ip:218.26.219.186","河北省	邢台区");
//		jedis.set("ip:222.68.207.11","海南省	海口市");
//		jedis.set("ip:61.53.137.50","河南省	郑州市");
//		jedis.set("ip:218.75.75.133","北京市	东城区");
//		jedis.set("ip:221.204.246.11","北京市	西城区");
//		jedis.set("ip:125.39.129.67","海南省	海口市");
//		jedis.set("ip:220.194.55.244","河北省	邢台区");
//		jedis.set("ip:125.70.229.30","河南省	郑州市");
//		jedis.set("ip:220.194.55.160","海南省	海口市");
//		jedis.set("ip:202.98.11.101","北京市	西城区");
//		jedis.set("ip:59.76.81.3 808","河北省	邢台区");
//		jedis.set("ip:121.11.87.171","北京市	西城区");
//		jedis.set("ip:121.9.221.188","河南省	郑州市");
//		jedis.set("ip:221.195.40.145","河北省	邢台区");


		BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\dev\\idea\\KafkaFlumeProject_20160519\\src\\main\\resources\\ip.data")));
		String line = "" ;
        String[] split = null ;
		while ( (line = reader.readLine() ) != null ){
			split = line.split("\t");
            if( split.length == 3  )
            jedis.set( "ip:"+split[0] , split[1]+"\t"+split[2] );
		}

		reader.close();

        //测试
        System.out.println( jedis.get("ip:59.76.81.3 808") );

        jedis.close();
    }
}
