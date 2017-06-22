package com.petapplication.entity;

import com.petapplication.utility.ModelBase;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author pradip
 */
@Entity
@Table(name = "user_menu")
public class UserMenu extends ModelBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "parent_id", nullable = false)
    private Long parentId;

    @Column(name = "menu_action", nullable = false)
    private String menuAction;

    @Column(name = "status")
    private Character status;

    @Column(name = "user_define")
    private Character userDefine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuAction() {
        return menuAction;
    }

    public void setMenuAction(String menuAction) {
        this.menuAction = menuAction;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Character getUserDefine() {
        return userDefine;
    }

    public void setUserDefine(Character userDefine) {
        this.userDefine = userDefine;
    }

}
