package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.MenuEntity;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
}
