import axios from "axios";

const URI = `http://localhost:${process.env.REACT_APP_SPRING_PORT}`;

export const fetchPost = async () => {
	const res = await axios.get(URI + `/evaluation/find`);
	return res.data;
}

export const fetchLogin = async (id: string, password: string) => {
	const res = await axios.post(URI + '/login', {
		id: id,
		password: password,
	});
	return res.data;
}
