package com.generic.search.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pradip on 6/21/17.
 * Email pradip@drac.com.np
 */
@Entity
@Table(name = "college")
public class College implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "college_code")
    private String collegeCode;

    @Column(name = "college_name")
    private String collegeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollegeCode() {
        return collegeCode;
    }

    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", collegeCode='" + collegeCode + '\'' +
                ", collegeName='" + collegeName + '\'' +
                '}';
    }
}
