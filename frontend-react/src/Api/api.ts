import axios from "axios";

export const fetchPost = async () => {
	//console.log('/evaluation/find')
	//console.log(process.env)
	const res = await axios.get('http://localhost:8090/evaluation/find');
	console.log(res.data);
	return res.data;
}

export const fetchLogin = async (id: string, password: string) => {
	const res = await axios.post('http://localhost:8090/login', {
	//const res = await axios.post(URI + '/login', {
		id: id,
		password: password,
	});
	return res.data;
}
