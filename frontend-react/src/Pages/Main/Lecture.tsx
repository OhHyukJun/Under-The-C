import { ILecture } from '../../Atoms/Lecture';

export const Lecture = (props: ILecture) => {
  return (
	<>
	<div >
		<div>Lecture</div>
		{props.title}
	</div>
	</>
  );
};
