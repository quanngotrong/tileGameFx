# tileGameFx
bản nâng cấp cảu TileAboutGame

sử dụng thêm javafx.fxml và maven

Thêm tính năng
+ save
+ thêm 1 skill cho boss
+ tối ưu 1 vài đoạn code
+ sửa vài lỗi
+ reset game về mậc định
+ các level sau thì quái sẽ có thêm chưởng(hiện tại chỉ có 1)
+ game bắt đầu với 2 chưởng(chưa làm ra chưởng mới lên chưa add được)
+ có thể viết chưởng theo template của các chưởng trước


giải thích các thay đổi:
*sử dụng maven: giúp quản lý các tài nguyên được thêm vào , dễ dàng mở rộng 
eg: 
+muốn update tài nguyên chỉ cần sửa file pom.xml cho version của tài nguyên đó lên sau đó ra lệnh cho nó tải tài nguyên về
+hoặc muốn thêm tài nguyên mới vào( eg: javafx.media ) cũng chỉ cần sửa file pom.xml

*sử dụng fxml:
+ thay tất cả các state lúc trước bằng các scene, và mỗi scene sẽ có 1 file fxml, 1 file java, 1 file controller , 1 file css, đi kèm
+ giữ lại gameState, time loop chỉ thực hiện khi đang chơi game, khi chơi xong thì sẽ tắt loop, giúp cho phần điều khiển tĩnh( không cần đổi màn hình liên tục) tốn ít tài nguyên hơn 
+ thay đổi một chút cơ chế dùng chưởng nên anh em đọc lại tí


*** anh design hộ tui mấy cái scene mới với :))) đéo biết design kiểu gì
