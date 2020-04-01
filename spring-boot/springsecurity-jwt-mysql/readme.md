Xin chào các bạn đọc, đây là lần đầu tiên mình viết một bài gọi là chia sẻ kiến thức của mình, nên có thể có nhiều thiếu sót, trong bài viết chỗ nào mình nói chưa đúng mọi người comment xuống bên dưới giúp mình nhé, mình xin cảm ơn!

### Công nghệ sử dụng
- Spring boot: để tạo và phát triển ứng dụng nhanh
- Spring Web: cái này để mình tạo web app, ở đây gọi là web service và mình dùng tiêu chuẩn restful api.
- Spring Security: còn cái spring security là để xác thực, phân quyền, mã hóa mật khẩu,... 
- Spring Jpa: để mình tương tác với data.
- JWT (JSON Web Token): ở đây sẽ là một cái chuỗi loằng ngoằng mà server tạo ra cho client, để client ném lên server, server sẽ đọc thông tin trong đó để xử lý.
- MySQL: là một hệ quản trị cơ sở dữ liệu mà nguồn mở. tóm lại dữ liệu sẽ được lưu vào đây :grimacing:


### Môi trường:
- Java 15: cái này mình tiện tay nên cứ phang bản mới nhất thôi. các bạn dùng **JAVA 8** trở lên là được rồi
- MySQL 8

### Công cụ:
- IntelliJ IDEA
- HeidiSQL
- Postman


## Bắt đầu chiến thôi :trollface:
### Thư viện sử dụng
*Ở đây mình dùng maven nhé*

		`<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
            <version>2.2.5.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
            <version>2.2.5.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
            <version>2.2.5.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.12</version>
		</dependency>
		<dependency>
			<groupId>com.nimbusds</groupId>
			<artifactId>nimbus-jose-jwt</artifactId>
			<version>8.8</version>
		</dependency>
		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.8.6</version>
		</dependency>
        <dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
            <version>8.0.19</version>
		</dependency>`

###Tạo entity
####User

	`@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY`
    private long userId;
    private String username;
    private String password;
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set<Role> permissions = new HashSet<>();

    public String getPassword() {
        return "";
    }
    public String passwordData() {
        return password;
    }
  `
- ở đây mình sử dụng thêm một số annotation:
`@Entity@Table(name = "t_user")@Getter@Setter`