
const Header = () => {
    return (
        <div className="max-w-2xl mx-auto">
      <nav className="border-gray-200 px-2 mb-10">
        <div className="container mx-auto flex flex-wrap justify-between">
          <a href="/" className="flex">
            <svg
              className="h-10 mr-3"
              width="51"
              height="70"
              viewBox="0 0 51 70"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
            </svg>
            <span className="self-center text-lg font-semibold whitespace-nowrap">
                Under-The-C
            </span>
          </a>
          <div className="flex md:order-2">
            <div className="relative mr-3 md:mr-0 hidden md:block">
              {/* Search input */}
              <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                <svg
                  className="w-5 h-5 text-gray-500"
                  fill="currentColor"
                  viewBox="0 0 20 20"
                  xmlns="http://www.w3.org/2000/svg"
                >
                </svg>
              </div>
              <input
                type="text"
                id="email-adress-icon"
                className="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full pl-10 p-2"
                placeholder="Search..."
              />
            </div>
          </div>
          <div className="hidden md:flex justify-between items-center w-full md:w-auto md:order-1" id="mobile-menu-3">
            <ul className="flex-col md:flex-row flex md:space-x-8 mt-4 md:mt-0 md:text-sm md:font-medium">
              <li>
                <a
                  href="/"
                  className="bg-blue-700 md:bg-transparent text-white block pl-3 pr-4 py-2 md:text-blue-700 md:p-0 rounded"
                  aria-current="page"
                >
                  Main
                </a>
              </li>
              <li>
                <a
                  href="/Board"
                  className="text-gray-700 hover:bg-gray-50 border-b border-gray-100 md:hover:bg-transparent md:border-0 block pl-3 pr-4 py-2 md:hover:text-blue-700 md:p-0"
                >
                  강의 평가
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
    );
};
  
  export default Header;
  