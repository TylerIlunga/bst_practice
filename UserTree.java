package user_tree;

public class UserTree {
  Node root;

  UserTree () {}

  public void add(int id, User userData) {
    if (root == null) {
      root = new Node(id, userData);
      return;
    }

    Node current = root;
    while (current != null) {
      if (current.id > id) {
        //go down left subtree
        if (current.left == null) {
          current.left = new Node(id, userData);
          return;
        }
        current = current.left;
      } else {
        //go down right subtree
        if (current.right == null) {
          current.right = new Node(id, userData);
          return;
        }
        current = current.right;
      }
    }
  }

  public User search(int id) {
    if (root == null) { return null; }

    Node current = root;
    while (current != null) {
      if (current.id == id) { return current.data; }
      current = (current.id > id) ? current.left : current.right;
    }

    return null;
  }

  public boolean contains(int id) {
    if (root == null) { return false; }

    Node current = root;
    while (current != null) {
      if (current.id == id) { return true; }
      current = (current.id > id) ? current.left : current.right;
    }

    return false;
  }

  public static void preOrderTraversal(Node n) {
    if (n == null) { return; }

    System.out.printf("\nCurrent Node:\n%s\n", n.toString());
    inOrderTraversal(n.left);
    inOrderTraversal(n.right);
  }

  public static void inOrderTraversal(Node n) {
    if (n == null) { return; }

    inOrderTraversal(n.left);
    System.out.printf("\nCurrent Node:\n%s\n", n.toString());
    inOrderTraversal(n.right);
  }

  public static void postOrderTraversal(Node n) {
    if (n == null) { return; }

    inOrderTraversal(n.left);
    inOrderTraversal(n.right);
    System.out.printf("\nCurrent Node:\n%s\n", n.toString());
  }

  private static class User {
    int id;
    String firstName;
    String lastName;
    String username;
    String password;
    Postal postalInfo;
    Education educationInfo;

    User (int i, String fn, String ln, String usrname, String p) {
      id = i;
      firstName = fn;
      lastName = ln;
      usrname = username;
      password = p;
    }

    public void setPostalInfo(int n, String str, String c, String st, int z) {
      postalInfo = new Postal(n, str, c, st, z);
    }

    public Postal getPostalInfo(Postal p) {
      return postalInfo;
    }

    public void setEducationInfo(String s, String m, String r, int gy, double g) {
      educationInfo = new Education(s, m, r, gy, g);
    }

    public Education getEducationInfo(Postal p) {
      return educationInfo;
    }

    public String toString() {
      return String.format(
          "ID: %d\nFull Name: %s %s\nPostal:\n%s\nEducation:\n%s\n",
          id, firstName, lastName, postalInfo.toString(), educationInfo.toString());
    }

    class Postal {
      int number;
      String street;
      String city;
      String state;
      int zipcode;

      Postal (int n, String str, String c, String st, int z) {
        number = n;
        street = str;
        city = c;
        state = st;
        zipcode = z;
      }

      public String toString() {
        return String.format("%d %s, %s, %s %d", number, street, city, state, zipcode);
      }
    }

    class Education {
      String school;
      String major;
      String rank;
      int graduationYear;
      double gpa;

      Education (String s, String m, String r, int gy, double g) {
        school = s;
        major = m;
        rank = r;
        graduationYear = gy;
        gpa = g;
      }

      public String toString() {
        return String.format(
            "College/University: %s\nMajor: %s\nRank: %s\nGrad Year: %d\nGPA: %1.1f",
            school, major, rank, graduationYear, gpa);
      }
    }
  }

  private class Node {
    int id;
    User data;
    Node left, right;

    Node (int i, User userData) {
      id = i;
      data = userData;
    }

    public void addChild(int i, User userData) {
      if (data == null) {
        id = i;
        data = userData;
        return;
      }

      Node current = root;
      while (current != null) {
        if (current.id > id) {
          //go down left subtree
          if (current.left == null) {
            current.left = new Node(i, userData);
            return;
          }
          current = current.left;
        } else {
          //go down right subtree
          if (current.right == null) {
            current.right = new Node(i, userData);
            return;
          }
          current = current.right;
        }
      }
    }

    @Override
    public String toString() {
      return String.format("ID: %d\nUser:\n%s\n", id, data.toString());
    }
  }

  public static void main(String[] args) {
    UserTree usrtree = new UserTree();
    User user0 = new User(1, "Joe", "Coop", "joco0101", "istr01010");
    user0.setPostalInfo(123, "Seseme Street", "Manhattan", "NY", 10001);
    user0.setEducationInfo("Seseme University", "Symbolic Systems", "Freshman", 2022, 4.0);
    User user1 = new User(2, "Moe", "Coop", "moco0101", "asdkfmds");
    user1.setPostalInfo(321, "Seseme Street", "Manhattan", "NY", 10001);
    user1.setEducationInfo("Seseme University", "Symbolic Systems", "Freshman", 2022, 3.0);
    User user2 = new User(2, "Moe", "Coop", "moco0101", "asdkfmds");
    user2.setPostalInfo(321, "Seseme Street", "Manhattan", "NY", 10001);
    user2.setEducationInfo("Seseme University", "Symbolic Systems", "Freshman", 2022, 3.0);
    User user3 = new User(2, "Moe", "Coop", "moco0101", "asdkfmds");
    user3.setPostalInfo(321, "Seseme Street", "Manhattan", "NY", 10001);
    user3.setEducationInfo("Seseme University", "Symbolic Systems", "Freshman", 2022, 3.0);
    User user4 = new User(2, "Moe", "Coop", "moco0101", "asdkfmds");
    user4.setPostalInfo(321, "Seseme Street", "Manhattan", "NY", 10001);
    user4.setEducationInfo("Seseme University", "Symbolic Systems", "Freshman", 2022, 3.0);
    usrtree.add(132, user0);
    usrtree.add(321, user1);
    usrtree.add(438, user2);
    usrtree.add(87, user3);
    usrtree.add(399, user4);
    UserTree.preOrderTraversal(usrtree.root);
    UserTree.inOrderTraversal(usrtree.root);
    UserTree.postOrderTraversal(usrtree.root);
    System.out.println(usrtree.contains(438));
    System.out.println(usrtree.contains(81));
    System.out.println(usrtree.contains(22));
    System.out.println(usrtree.contains(399));
  }

}
