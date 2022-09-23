import logo from './logo.svg';
import {useState, useEffect} from 'react';
import {getAllCustomers} from "./client";
//import {successNotification, errorNotification} from "./Notification";

import {
    Layout,
    Menu,
    Breadcrumb,
    Table,
    Spin,
    Empty,
    Button,Tag, Badge, Popconfirm, Radio, Image
} from 'antd';

import {
    DesktopOutlined,
    PieChartOutlined,
    FileOutlined,
    TeamOutlined,
    UserOutlined,
    LoadingOutlined,
    PlusOutlined
} from '@ant-design/icons';
//import StudentDrawerForm from "./StudentDrawerForm";
import './App.css';

const {Header, Content, Footer, Sider} = Layout;
const {SubMenu} = Menu;
const columns = fetchCustomers => [
    {
        title: 'Id',
        dataIndex: 'id',
        key: 'id',
        width: 70
    },
    {
        title: 'Last Name',
        dataIndex: 'lastName',
        key: 'lastName',
        width: 250
    },
    {
        title: 'Name',
        dataIndex: 'firstName',
        key: 'firstName',
        width: 250
    },
    {
        title: 'JMBG',
        dataIndex: 'jmbg',
        key: 'jmbg',
        width: 150
    },
    {
        title: 'Address',
        dataIndex: 'address',
        key: 'address',
        width: 250
    },
    {
        title: 'ID No',
        dataIndex: 'brLK',
        key: 'brLK',
        width: 120
    },
    {
        title: 'Issued by PD',
        dataIndex: 'pu',
        key: 'pu',
        width: 120
    },
    {
        title: 'Email',
        dataIndex: 'email',
        key: 'email',
        width: 250
    },
    {
        title: 'Phone ',
        dataIndex: 'phoneNumber',
        key: 'phoneNumber',
         width: 120
    }
];

function App() {

    const[customers, setCustomers] = useState([]);
    const [fetching, setFetching] = useState(true);
    const [collapsed, setCollapsed] = useState(false);

    const fetchCustomers = () =>
        getAllCustomers().
            then(res => res.json())
                    .then(data => {
                        console.log(data);
                        setCustomers(data);
                        setFetching(false);
                    });

    useEffect( () => {
        console.log("component is mounted");
        fetchCustomers();
           }, []);

    const renderCustomers = () => {
         if (fetching) {
                    return <Spin />
                }
        if(customers.length <= 0){return <Empty/>}
        return <>
                <Table
                               dataSource={customers}
                               columns={columns(fetchCustomers)}
                               bordered
                               title={() =>
                               <>
                                     <Tag>Number of customers</Tag>
                                     <Badge count={customers.length} className="site-badge-count-4"/>
                                      <br/> <br/>
                                   <Button
                                       //onClick={() => setShowDrawer(!showDrawer)}
                                       type="primary" shape="round" icon={<PlusOutlined/>} size="small">
                                       Add New Customer
                                   </Button>
                               </>
                               }
                               pagination={{pageSize: 10}}
                               scroll={{y: 600}}
                               rowKey={customer => customer.id}
                           />
            </>
    }

       return <Layout style={{minHeight: '100vh'}}>
           <Sider collapsible collapsed={collapsed}
                  onCollapse={setCollapsed}>
               <div className="logo"  />
                   <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline">
                   <Menu.Item key="1" icon={<PieChartOutlined/>}>
                       Option 1
                   </Menu.Item>
                   <Menu.Item key="2" icon={<DesktopOutlined/>}>
                       Option 2
                   </Menu.Item>
                   <SubMenu key="sub1" icon={<UserOutlined/>} title="User">
                       <Menu.Item key="3">Tom</Menu.Item>
                       <Menu.Item key="4">
                       bill
                       </Menu.Item>
                       <Menu.Item key="5">Alex</Menu.Item>
                   </SubMenu>
                   <SubMenu key="sub2" icon={<TeamOutlined/>} title="Team">
                       <Menu.Item key="6">Team 1</Menu.Item>
                       <Menu.Item key="8">Team 2</Menu.Item>
                   </SubMenu>
                   <Menu.Item key="9" icon={<FileOutlined/>}>
                       Files
                   </Menu.Item>
               </Menu>
           </Sider>

           <Layout className="site-layout">
               <Header className="site-layout-background" style={{padding: 0}}/>
               <Content style={{margin: '0 16px'}}>
                   <Breadcrumb style={{margin: '16px 0'}}>
                       <Breadcrumb.Item>User</Breadcrumb.Item>
                   </Breadcrumb>
                   <div className="site-layout-background" style={{padding: 24, minHeight: 360}}>
                        {renderCustomers()}
                   </div>
               </Content>
               <Footer style={{textAlign: 'center'}}>
                   <Image
                    width={200}
                    src="https://user-images.githubusercontent.com/72573914/185918303-3010c9ac-7b12-4015-a016-f1231d777336.png"
                    />
               </Footer>
           </Layout>
       </Layout>
}

export default App;
