package org.zerock.mreview.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mreview.entity.Movie;
import org.zerock.mreview.entity.Member;
import org.zerock.mreview.entity.Review;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class ReviewRepositoryTests {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMovieReviews(){

        IntStream.rangeClosed(1,200).forEach(i -> {
            //영화 번호
            Long mno = (long)(Math.random()*100) + 1;

            //리뷰어 번호
            Long mid = (long)(Math.random() * 100) + 1;
            Member member = Member.builder().mid(mid).build();
            Movie movie = Movie.builder().mno(mno).build();

            Review movieReview = Review.builder()
                    .member(member)
                    .movie(movie)
                    .grade((int)(Math.random() * 5 + 1))
                    .text("이 영화에 대한 느낌..." + i)
                    .build();

            reviewRepository.save(movieReview);
        });
    }

    @Test
    public void testGetMovieReviews(){

        Movie movie = Movie.builder().mno(92L).build();

        List<Review> result = reviewRepository.findByMovie(movie);

        result.forEach(movieReview -> {
            System.out.println(movieReview.getReviewnum());
            System.out.println("\t"+ movieReview.getReviewnum());
            System.out.println("\t"+ movieReview.getText());
            System.out.println("\t"+ movieReview.getMember().getEmail());
            System.out.println("--------------------------------------");
        });
    }

    @Commit
    @Transactional
    @Test
    public void testDeleteMember(){

        Long mid = 1L; //member의 mid

        Member member = Member.builder().mid(mid).build();

        //순서 주의 - 리뷰부터 지워야 함
        reviewRepository.deleteByMember(member);
        memberRepository.deleteById(mid);
    }
}
