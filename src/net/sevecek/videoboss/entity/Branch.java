package net.sevecek.videoboss.entity;

import javax.persistence.*;

@Entity
@Table(name = "Branches")
public class Branch extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String branchName;

    //------------------------------------------------------------------------

    @Deprecated
    protected Branch() {
    }

    public Branch(Integer id, String branchName) {
        this.id = id;
        this.branchName = branchName;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getBranchName() {
        return branchName;
    }

    //------------------------------------------------------------------------

    @Override
    protected boolean testInstanceOf(Object other) {
        return other instanceof Branch;
    }


    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", branchName='" + branchName + '\'' +
                '}';
    }
}
