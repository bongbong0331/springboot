package com.bongcoding.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bongcoding.blog.dto.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{

}
