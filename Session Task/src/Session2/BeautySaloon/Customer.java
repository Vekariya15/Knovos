package Session2.BeautySaloon;

/**
 * This class we can create class for store only customer data
 */
class Customer {
    String name;
    Boolean member = false; // Initialize member to false
    String membertype;

    // create a getter and setter method for all the variables
    Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Boolean isMember() {
        return member;
    }

    public void setMember(Boolean member) {
        this.member = member;
    }

    public String getMemberType() {
        return membertype;
    }

    public void setMemberType(String memberType) {
        this.membertype = memberType;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", member=" + member +
                ", membertype='" + membertype + '\'' +
                '}';
    }
}
