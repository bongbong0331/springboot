package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@EqualsAndHashCode(callSuper = false) // 상속시 선언 룸북을 사용하게 되면 처리해주는 코드
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Actor extends CommonRes{
//@JsonProperty("actor_id")
	
	private String actorId;
	private String firstName;
	private String lastName;
	private String lastUpdate;
}
