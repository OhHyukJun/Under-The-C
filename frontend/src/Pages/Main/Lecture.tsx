import { LectureI } from './Main'

export const Lecture = (props: LectureI) => {
  return (
	<>
	<div >
		<div>Lecture</div>
		{props.title}
	</div>
	</>
  );
};
