## Vấn đề
- Nay mình được các giao cho cái việc đồng bộ cái database với elasticsearch, đầu tiên là mình dùng thằng logstash cho nó chạy schedule 5 phút 1 phát, nhưng nó lại bị miss cái trường hợp delete và lại nhìn nó không ổn lắm :bowtie: . Vậy là mình đi hỏi các cao nhân, các cao nhân chỉ cứ đọc binlog ra rồi ghi vào ES, việc này sẽ đảm bảo chắc chắn hành động đã thực hiện thành công trên database rồi mình làm tương tự với ES thôi :grimacing:
- Nhưng bên oracle thì không phải binlog, nó là archived log thì phải, tìm mãi chả có bài gì nói liên quan đến thằng này (chắc tại mình không biết key), đọc doc của oracle thì tớ sợ lắm :cry: ấy thế vô tình thế nào lại thấy cái annotation **EntityListeners** 

## EntityListeners
- Cơ bản này nó sẽ lắng nghe cái entity của mình trước và sau mình làm một cái gì đó và động đên database với cái entity tương ứng :tired_face:
- Đây các bạn đọc thêm ở đây nhé https://docs.jboss.org/hibernate/core/4.0/hem/en-US/html/listeners.html

## Thí dụ
- Đầu tiên mình tạo một class entity listener

```
@Slf4j
public class UserEntityListener {

    @PrePersist
    void onPrePersist(UserEntity user) {
        log.info("PrePersist: " + user);
    }

    @PostPersist
    void onPostPersist(UserEntity user) {
        log.info("PostPersist: " + user);
    }

    @PreUpdate
    void onPreUpdate(UserEntity user) {
        log.info("PreUpdate: " + user);
    }

    @PostUpdate
    void onPostUpdate(UserEntity user) {
        log.info("PostUpdate: " + user);
    }

    @PreRemove
    void onPreRemove(UserEntity user) {
        log.info("PreRemove: " + user);
    }

    @PostRemove
    void onPostRemove(UserEntity user) {
        log.info("PostRemove: " + user);
    }
}
```
- Đây với mỗi hành động tương ứng nó sẽ vào pre trước khi nó động đên database và vào post sau khi nó đông tới database. Rồi tiếp mình tạo cái entity này

```
@Entity
@EntityListeners(UserEntityListener.class)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
}
```
- Đây mình dùng cái annotation **EntityListeners**  với cái class listener mình vừa tạo
- Tiếp là tới đoạn thử này

```
@SpringBootApplication
public class JpaEntityListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaEntityListenerApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            UserEntity user = UserEntity.builder()
                    .username("xin chao")
                    .password("123123")
                    .build();
            repository.saveAndFlush(user);

            Optional<UserEntity> userOptional = repository.findById(user.getId());
            if (userOptional.isEmpty()) throw new NotFoundException("not found");
            userOptional.get().setUsername("hello");
            repository.save(userOptional.get());

            repository.delete(user);
        };
    }

}
```
## Tổng kết
- Demo của mình chỉ có vậy thôi, còn phần code thực tế của mình sau khi ví dụ cập nhật thành công, phần xử lý ở đấy sẽ vào phương thức **onPostUpdate** rồi ở đấy mình sẽ push một message lên kafka để cái động chí làm việc với ES sẽ cập nhật lại :D
- Nếu các bạn không biết làm gì thì có thể lưu log chẳng hạn, mình nghĩ nó cũng hữu ích đấy :innocent:
- Link bài viết https://kipalog.com/posts/Spring-boot--Jpa-entity-listener-thuc-hien-mot-cai-gi-do-truoc-va-sau-khi-dong-vao-database
