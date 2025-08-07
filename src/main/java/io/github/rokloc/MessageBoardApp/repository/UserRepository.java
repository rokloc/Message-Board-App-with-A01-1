//DB操作をする

package io.github.rokloc.MessageBoardApp.repository;

import io.github.rokloc.MessageBoardApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
	
	
}


/*
save(entity)	新規作成 or 更新
findById(id)	主キーで1件検索（Optionalで返る）
findAll()	全件取得
delete(entity)	削除
count()	件数カウント
existsById(id)	主キーで存在チェック(boolean)

*/
