/*
 * package life.pifrans.dao;
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.junit.Assert.assertNotEquals; import static org.junit.Assert.assertTrue;
 * 
 * import java.util.ArrayList; import java.util.Date; import java.util.List;
 * 
 * import org.junit.Test;
 * 
 * import life.pifrans.daos.GenericImplementationDAO; import
 * life.pifrans.models.User;
 * 
 * 
 * Fazer todos os teste com a tabela (user) vazia
 * 
 * 
 * public class TestUser extends GenericImplementationDAO<User, Long> {
 * 
 * 
 * 
 * @Test public void save() throws Exception { User userLocal = new User(null,
 * "Tibío", "Capetei", "tibio@live.com", "222", "user", new
 * Date(System.currentTimeMillis())); User userDB = new User(); TestUser dao =
 * new TestUser(); userDB = dao.save(userLocal);
 * 
 * assertEquals(userLocal.getName(), userDB.getName());
 * assertEquals(userLocal.getLastName(), userDB.getLastName());
 * assertEquals(userLocal.getPermission(), userDB.getPermission());
 * 
 * dao.remove(User.class, userDB.getId()); }
 * 
 * @Test public void remove() throws Exception { User user = new User(5L,
 * "Tibío", "Capetei", "tibio@live.com", "222", "user", new
 * Date(System.currentTimeMillis())); TestUser dao = new TestUser(); user =
 * dao.save(user); boolean isRemove = dao.remove(User.class, user.getId());
 * 
 * assertTrue(isRemove); }
 * 
 * @Test public void update() throws Exception { User userLocal = new User(null,
 * "Tibío", "Capetei", "tibio@live.com", "222", "user", new
 * Date(System.currentTimeMillis())); User userDB = new User(); TestUser dao =
 * new TestUser(); userDB = dao.save(userLocal);
 * 
 * assertEquals(userLocal.getName(), userDB.getName());
 * assertEquals(userLocal.getLastName(), userDB.getLastName());
 * assertEquals(userLocal.getPermission(), userDB.getPermission());
 * 
 * userDB = dao.update( new User(userDB.getId(), "Tibío", "Capetei",
 * "tibio@live.com", "222", "admin", new Date(System.currentTimeMillis())));
 * 
 * assertNotEquals(userLocal.getPermission(), userDB.getPermission());
 * 
 * dao.remove(User.class, userDB.getId()); }
 * 
 * @Test public void findAll() throws Exception { List<User> usersLocal = new
 * ArrayList<>(); List<User> usersDB = new ArrayList<>(); TestUser dao = new
 * TestUser();
 * 
 * for (int i = 0; i < 5; i++) { User user = new User(null, "Name" + i,
 * "LastName" + i, "tibio" + i + "@live.com", "222", null, new
 * Date(System.currentTimeMillis())); if (i % 2 == 0) {
 * user.setPermission("admin"); } else { user.setPermission("user"); }
 * usersLocal.add(user); user = dao.save(user); usersDB.add(user); }
 * 
 * for (int i = 0; i < 5; i++) { assertEquals(usersLocal.get(i).getName(),
 * usersDB.get(i).getName()); assertEquals(usersLocal.get(i).getLastName(),
 * usersDB.get(i).getLastName());
 * assertEquals(usersLocal.get(i).getPermission(),
 * usersDB.get(i).getPermission()); }
 * 
 * for (User user : usersDB) { dao.remove(User.class, user.getId()); } }
 * 
 * @Test public void findAllT() throws Exception { List<User> usersLocal = new
 * ArrayList<>(); List<User> usersDB = new ArrayList<>(); TestUser dao = new
 * TestUser();
 * 
 * for (int i = 0; i < 5; i++) { User user = new User(null, "Name" + i,
 * "LastName" + i, "tibio" + i + "@live.com", "222", null, new
 * Date(System.currentTimeMillis())); if (i % 2 == 0) {
 * user.setPermission("admin"); } else { user.setPermission("user"); }
 * usersLocal.add(user); user = dao.save(user); usersDB.add(user); }
 * 
 * usersDB = dao.findAll(User.class);
 * 
 * for (int i = 0; i < 5; i++) { assertEquals(usersLocal.size(),
 * usersDB.size()); }
 * 
 * for (User user : usersDB) { dao.remove(User.class, user.getId()); } } }
 */