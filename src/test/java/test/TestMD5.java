package test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestMD5 {
	@Test
	public void test1(){
		String str1 = "abc123";
		String str2="abc123";
		String rsStr1 = DigestUtils.md5Hex(str1);
		String rsStr2 = DigestUtils.md5Hex(str2);
		System.out.println(rsStr1);
		System.out.println(rsStr2);
	}

}
