package ru.ugrasu.journal.UnitTest;

import ru.ugrasu.journal.JournalApplicationTests;

public class UserServiceTest extends JournalApplicationTests {

//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private UserService userService;
//
//    @Test
//    public void findByIdMustUserEntity() throws Exception {
//        UserEntity u = new UserEntity();
//
//        RoleEntity r = new RoleEntity();
//        r.setId(1);
//        r.setName("admin");
//
//        StudyGroupEntity g = new StudyGroupEntity();
//        g.setId(1);
//        g.setName("1541б");
//
//        u.setId(1);
//        u.setName("test");
//        u.setStudyGroupByStudyGroup(g);
//        u.setRoleByRole(r);
//
//        when(userRepository.findOne(u.getId())).thenReturn(u);
//
//        UserEntity userEntity = userService.findById(1);
//
//        assertEquals(u.getId(), userEntity.getId());
//    }
//
//    @Test(expected = ResourceNotFoundException.class)
//    public void findByIdMustReturnResourceNotFoundException() throws ResourceNotFoundException {
//        when(userRepository.findOne(Integer.MIN_VALUE)).thenReturn(null);
//        userService.findById(Integer.MIN_VALUE);
//    }

}