import Header from '../../Layout/Header';
import { useQuery, useQueryClient } from '@tanstack/react-query';
import { useRecoilState } from "recoil";
import { Lecture } from './Lecture';
import { lectureListState, ILecture } from '../../Atoms/Lecture';
import { fetchPost } from '../../Api/api';

const Main = () => {
	const [ lectureList, setLectureList ] = useRecoilState(lectureListState);
  const { isLoading, isError, data } = useQuery(['lecture'], fetchPost, {
		onSuccess: (data) => setLectureList(data)
		//기본 캐시 타임 == 5min
	});
  if (isLoading)
    return <h2>Loading...</h2>
	
	if (isError)
		return <h2>Error...</h2>

  return (
    <>
      <Header />
      <h1>Main page</h1>
      {
		lectureList?.map((item: ILecture) => {
			return <Lecture key={item.id} {...item} /> })
	  }
    </>
  );
};

export default Main;
