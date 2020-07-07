package com.pete.budgetrequestbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pete.budgetrequestbackend.util.DateUtil;

import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	DateUtil dateUtil;
/*
	@Test
	void given30JuneThisCalYear_WhengetfinYearInvoked_returnCorrectFinYear(){

		LocalDate now = LocalDate.now();
		LocalDate thirtyJuneThisFinYear = LocalDate.of(now.getYear() , 6, 30);

		assertThat(thirtyJuneThisFinYear)
			.isEqualTo(dateUtil.getEndOfCurrentFinYearFromNow(now));

	}

	@Test
	void given1stJulyThisCalyear_whenGetFinYearInvoked_thenreturnCorrectFinYear(){
		LocalDate now = LocalDate.now();
		LocalDate firststJulyThisCalyear = LocalDate.of(now.getYear() , 7, 1);

		assertThat(firststJulyThisCalyear)
			.isEqualTo(dateUtil.getEndOfCurrentFinYearFromNow(now).plusDays(1));

	}
*/

}
