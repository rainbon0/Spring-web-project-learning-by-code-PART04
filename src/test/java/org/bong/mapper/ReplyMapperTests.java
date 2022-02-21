package org.bong.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.bong.domain.Criteria;
import org.bong.domain.ReplyVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:web/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
    @Setter(onMethod_ = {@Autowired})
    private ReplyMapper mapper;

    private Long[] bnoArr = {373L, 372L, 371L, 370L, 369L};

    @Test
    public void testMapper(){
        log.info(mapper);

    }

    @Test
    public void testCreate(){
        IntStream.rangeClosed(1, 10).forEach(i -> {
            ReplyVO vo = new ReplyVO();

            //  게시물의 번호
            vo.setBno(bnoArr[i%5]);
            vo.setReply("댓글 테스트 : " + i);
            vo.setReplyer("replyer" +i);
            mapper.insert(vo);

        });
    }

    @Test
    public void testRead(){
        Long targetRno = 5L;

        ReplyVO vo = mapper.read(targetRno);

        log.info(vo);
    }

    @Test
    public void testDelete(){
        Long targetRno = 1L;
        mapper.delete(targetRno);
    }

    @Test
    public void testUpdate(){
        Long targetRno = 10L;

        ReplyVO vo = mapper.read(targetRno);

        vo.setReplyer("Update Reply");

        int count = mapper.update(vo);

        log.info("Update Count :" +count );
    }

    @Test
    public void testList(){
        Criteria cri = new Criteria();
        List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
        replies.forEach(reply -> log.info(reply));
    }


    @Test
    public void testList2() {

        Criteria cri = new Criteria(1, 10);


        List<ReplyVO> replies = mapper.getListWithPaging(cri, 370L);

        replies.forEach(reply -> log.info(reply));

    }

}










