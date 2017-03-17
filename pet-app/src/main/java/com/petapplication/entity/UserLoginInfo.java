package com.petapplication.entity;

import com.petapplication.utility.ModelBase;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "user_login_info")
@Getter
@Setter
public class UserLoginInfo extends ModelBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private Character status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "login_date_time")
    private Date loginDateTime;

    @Column(name = "profile_id")
    private Long profileId;

    @Column(name = "role", nullable = false)
    private Character role;

}
