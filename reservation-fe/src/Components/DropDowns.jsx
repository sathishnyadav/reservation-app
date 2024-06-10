import Dropdown from 'react-bootstrap/Dropdown';

function Dropdown1() {
  return (
    <Dropdown>
      <Dropdown.Toggle variant="success" id="dropdown-basic">
       Account
      </Dropdown.Toggle>

      <Dropdown.Menu>
        <Dropdown.Item href="/adminhomepage/addbus">AddBus</Dropdown.Item>
        <Dropdown.Item href="/adminhomepage/viewbus">Buses List</Dropdown.Item>
        <Dropdown.Item href="#/action-2">Edit Profile</Dropdown.Item>
        <Dropdown.Item href="/">Logout</Dropdown.Item>
      </Dropdown.Menu>
    </Dropdown>
  );
}

export default Dropdown1;