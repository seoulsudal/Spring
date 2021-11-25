import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.lessonvo.LessonVO;

@Controller
@RequestMapping(value = "/lesson")
public class LessonController {
	private static final String CONTECT_PATH = "lesson";
	
	@Autowired
	private LessonService lessonService;
	
	// 과목 전체 조회
	@RequestMapping("/listLesson")
	public ModelAndView listLesson(@ModelAttribute LessonVO param) {
		
	}
}
