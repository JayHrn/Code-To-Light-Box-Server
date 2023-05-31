package com.nchu.software;

import com.nchu.software.domain.Level;
import com.nchu.software.domain.LevelDifficulty;
import com.nchu.software.domain.Record;
import com.nchu.software.domain.User;
import com.nchu.software.service.LevelDifficultyService;
import com.nchu.software.service.LevelService;
import com.nchu.software.service.RecordService;
import com.nchu.software.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerApplicationTests {
	@Autowired
	private UserService userService;
	@Autowired
	private LevelDifficultyService levelDifficultyService;
	@Autowired
	private LevelService levelService;
	@Autowired
	private RecordService recordService;

	@Test
	void contextLoads() {
//		User user=new User();
//		user.setUsername("123456");
//		user.setPassword("123456");
//		user.setEmail("1569624265@qq.com");
//		userService.save(user);
	}
	@Test
	void addLevelDifficulty(){
//		LevelDifficulty levelDifficulty=new LevelDifficulty();
//		levelDifficulty.setName("困难");
//		levelDifficulty.setGrade(7);
//		levelDifficultyService.save(levelDifficulty);
	}
	@Test
	void addLevel(){
//		Level level=new Level();
//		level.setName("第三关");
//		level.setDifficulty(Long.valueOf("1657991642466406401"));
//		level.setDescription("这是第三关游戏");
//		level.setPreLevel(Long.valueOf("1657993115954806785"));
//		levelService.save(level);
	}
	@Test
	void addRecord(){
		Record record=new Record();
		record.setLevelId(Long.valueOf("1657992799179972609"));
		record.setUserId(Long.valueOf("1656202740629934081"));
		record.setTime(62);
		recordService.save(record);
	}

}
